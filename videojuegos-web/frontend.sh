#!/bin/sh
set -eu
cd "$(dirname "$0")"
: "${PAYARA_MICRO_JAR:?Set PAYARA_MICRO_JAR to your Payara Micro 7 JAR}"
exec java "-Drest.videojuegos.url/mp-rest/url=${BACKEND_URL:-http://localhost:8081}" -jar "$PAYARA_MICRO_JAR" --noCluster --port "${WEB_PORT:-8092}" --deploy ./target/ROOT.war
