#!/usr/bin/env python3
import os
import re
import subprocess
import sys
import xml.etree.ElementTree as ET
from pathlib import Path

BASE = sys.argv[1] if len(sys.argv) > 1 else ""
RISK = os.getenv("FIRST_PASS_RISK", "MEDIUM").upper()
LINE_MIN = 100.0 if RISK == "HIGH" else 80.0
BRANCH_MIN = 100.0 if RISK == "HIGH" else 70.0

if not BASE or BASE == "null" or set(BASE) == {"0"}:
    try:
        BASE = subprocess.check_output(["git", "rev-parse", "HEAD^"], text=True).strip()
    except subprocess.CalledProcessError:
        BASE = subprocess.check_output(["git", "rev-parse", "HEAD"], text=True).strip()

def changed_lines(base: str):
    cmd = [
        "git", "diff", "--unified=0", f"{base}...HEAD", "--",
        "app/src/main/java", "backend/src/main/java"
    ]
    output = subprocess.check_output(cmd, text=True, errors="replace")
    result = {}
    current = None
    for line in output.splitlines():
        if line.startswith("+++ b/"):
            current = line[6:]
            result.setdefault(current, set())
        elif current and line.startswith("@@"):
            match = re.search(r"\+(\d+)(?:,(\d+))?", line)
            if not match:
                continue
            start = int(match.group(1))
            count = int(match.group(2) or "1")
            for number in range(start, start + count):
                result[current].add(number)
    return result

def load_report(xml_path: Path, source_root: str):
    coverage = {}
    if not xml_path.exists():
        return coverage

    root = ET.parse(xml_path).getroot()
    for package in root.findall("package"):
        package_name = package.attrib.get("name", "")
        for source in package.findall("sourcefile"):
            source_name = source.attrib["name"]
            path = f"{source_root}/{package_name}/{source_name}".replace("//", "/")
            lines = {}
            for line in source.findall("line"):
                nr = int(line.attrib["nr"])
                lines[nr] = {
                    "ci": int(line.attrib.get("ci", 0)),
                    "mi": int(line.attrib.get("mi", 0)),
                    "cb": int(line.attrib.get("cb", 0)),
                    "mb": int(line.attrib.get("mb", 0)),
                }
            coverage[path] = lines
    return coverage

reports = [
    (Path("app/build/reports/jacoco/jacocoDebugUnitTestReport/jacocoDebugUnitTestReport.xml"), "app/src/main/java"),
    (Path("backend/target/site/jacoco/jacoco.xml"), "backend/src/main/java"),
]

all_coverage = {}
for xml_path, root in reports:
    all_coverage.update(load_report(xml_path, root))

changed = changed_lines(BASE)
line_total = 0
line_covered = 0
branch_total = 0
branch_covered = 0
uncovered = []

for path, numbers in sorted(changed.items()):
    file_coverage = all_coverage.get(path, {})
    for number in sorted(numbers):
        data = file_coverage.get(number)
        if data is None:
            continue
        line_total += 1
        if data["ci"] > 0:
            line_covered += 1
        else:
            uncovered.append(f"{path}:{number}")
        branch_total += data["cb"] + data["mb"]
        branch_covered += data["cb"]

if line_total == 0:
    print("Cobertura diferencial: no hay líneas ejecutables modificadas medidas por JaCoCo.")
    sys.exit(0)

line_pct = line_covered * 100.0 / line_total
branch_pct = 100.0 if branch_total == 0 else branch_covered * 100.0 / branch_total

print(f"Riesgo: {RISK}")
print(f"Lines diferenciales: {line_covered}/{line_total} = {line_pct:.2f}% (mínimo {LINE_MIN:.0f}%)")
if branch_total:
    print(f"Branches diferenciales: {branch_covered}/{branch_total} = {branch_pct:.2f}% (mínimo {BRANCH_MIN:.0f}%)")
else:
    print("Branches diferenciales: no existen ramas medidas en las líneas cambiadas.")

if uncovered:
    print("Líneas modificadas sin cobertura:")
    for item in uncovered[:50]:
        print(f" - {item}")

failed = line_pct < LINE_MIN or (branch_total > 0 and branch_pct < BRANCH_MIN)
if failed:
    print("Quality Gate rechazado por cobertura diferencial.")
    sys.exit(1)

print("Cobertura diferencial OK")
