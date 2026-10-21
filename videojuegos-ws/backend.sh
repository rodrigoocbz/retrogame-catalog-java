#!/bin/sh
set -eu
cd "$(dirname "$0")"
: "${DB_PASSWORD:?Set DB_PASSWORD before starting the backend}"
: "${PAYARA_MICRO_JAR:?Set PAYARA_MICRO_JAR to your Payara Micro 7 JAR}"
exec java -jar "$PAYARA_MICRO_JAR" --noCluster --port "${API_PORT:-8081}" --deploy ./target/ROOT.war --contextroot /
