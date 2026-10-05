#!/usr/bin/env bash
set -euo pipefail

BASE_SHA="${1:-}"

if [[ -z "$BASE_SHA" || "$BASE_SHA" == "null" || "$BASE_SHA" == "0000000000000000000000000000000000000000" ]]; then
  BASE_SHA="$(git rev-parse HEAD^ 2>/dev/null || git rev-parse HEAD)"
fi

if ! git cat-file -e "$BASE_SHA^{commit}" 2>/dev/null; then
  git fetch --no-tags origin "$BASE_SHA"
fi

echo "Full Gate base: $BASE_SHA"

python3 scripts/ci/check-qa-governance.py

./gradlew :app:assembleDebug :app:testDebugUnitTest :app:jacocoDebugUnitTestReport

if [[ -f backend/pom.xml ]]; then
  mvn -B -f backend/pom.xml test jacoco:report package
fi

python3 scripts/ci/differential-coverage.py "$BASE_SHA"

echo "Full Gate local passed."
echo "La certificación completa termina cuando connectedDebugAndroidTest también queda verde en el emulador de CI."
