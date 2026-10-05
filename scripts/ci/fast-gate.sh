#!/usr/bin/env bash
set -euo pipefail

BASE_SHA="${1:-}"
ZERO_SHA="0000000000000000000000000000000000000000"

if [[ -z "$BASE_SHA" || "$BASE_SHA" == "null" || "$BASE_SHA" == "$ZERO_SHA" ]]; then
  BASE_SHA="$(git rev-parse HEAD^ 2>/dev/null || git rev-parse HEAD)"
fi

if ! git cat-file -e "$BASE_SHA^{commit}" 2>/dev/null; then
  git fetch --no-tags origin "$BASE_SHA"
fi

mapfile -t CHANGED < <(git diff --name-only "$BASE_SHA"...HEAD)

echo "Fast Gate base: $BASE_SHA"
printf ' - %s\n' "${CHANGED[@]:-}"

python3 scripts/ci/check-qa-governance.py

ANDROID_CHANGED=false
BACKEND_CHANGED=false

for file in "${CHANGED[@]}"; do
  case "$file" in
    app/*|app/**/*|build.gradle.kts|settings.gradle.kts|gradle/*|gradle/**/*)
      ANDROID_CHANGED=true
      ;;
    backend/*|backend/**/*)
      BACKEND_CHANGED=true
      ;;
  esac
done

if [[ "$ANDROID_CHANGED" == true ]]; then
  ./gradlew :app:assembleDebug :app:testDebugUnitTest :app:jacocoDebugUnitTestReport
fi

if [[ "$BACKEND_CHANGED" == true && -f backend/pom.xml ]]; then
  mvn -B -f backend/pom.xml test jacoco:report
fi

python3 scripts/ci/differential-coverage.py "$BASE_SHA"

echo "Fast Gate passed."
