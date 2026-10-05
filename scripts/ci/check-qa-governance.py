#!/usr/bin/env python3
from pathlib import Path
import sys

required = [
    Path("AGENTS.md"),
    Path("docs/engineering/QA_POLICY.md"),
    Path("docs/engineering/DEFINITION_OF_DONE.md"),
    Path("scripts/ci/fast-gate.sh"),
    Path("scripts/ci/full-gate.sh"),
    Path("scripts/ci/differential-coverage.py"),
]

missing = [str(path) for path in required if not path.exists()]
if missing:
    print("QA governance incompleto. Faltan:")
    for path in missing:
        print(f" - {path}")
    sys.exit(1)

qa = Path("docs/engineering/QA_POLICY.md").read_text(encoding="utf-8")
for text in ["Lines = 100%", "Branches = 100%", "RED → GREEN", "HEAD exacto"]:
    if text not in qa:
        print(f"QA_POLICY.md no contiene la regla obligatoria: {text}")
        sys.exit(1)

app_gradle = Path("app/build.gradle.kts").read_text(encoding="utf-8")
if "jacocoDebugUnitTestReport" not in app_gradle or "jacoco" not in app_gradle:
    print("Android debe mantener JaCoCo y jacocoDebugUnitTestReport.")
    sys.exit(1)

backend_pom = Path("backend/pom.xml")
if backend_pom.exists():
    pom = backend_pom.read_text(encoding="utf-8")
    if "jacoco-maven-plugin" not in pom:
        print("Existe backend Spring Boot, pero backend/pom.xml no configura jacoco-maven-plugin.")
        sys.exit(1)

print("QA governance OK")
