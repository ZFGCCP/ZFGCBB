#!/bin/bash

set -e

# Log function
log() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $*"
}

log "Starting server bootstrap..."

usage() {
  echo "Usage: $0 -h HOST_NAME -u USER"
  echo ""
  echo "  -h HOST_NAME       Hostname or IP address (e.g., 192.0.2.10)"
  echo "  -u USER            SSH username (e.g., root)"
  echo "  -p PORT             Port to use (e.g., 8080)"
  echo ""
  echo "Example:"
  echo "  $0 -h 192.0.2.10 -u root"
  exit 1
}

while getopts ":h:u:p:" opt; do
  case $opt in
    h) HOST_NAME="$OPTARG" ;;
    u) USER_NAME="$OPTARG" ;;
    p) PORT="$OPTARG" ;;
    *) usage ;;
  esac
done

if [[ -z "$HOST_NAME" || -z "$USER_NAME" || -z "$PORT" ]]; then
  usage
fi

SCRIPT_DIR=$(dirname "$0")

scp "$SCRIPT_DIR"/../../../scripts/deployment/00.manual.setup-runner-linux-user.sh "$USER_NAME@$HOST_NAME:/tmp/"
ssh "$USER_NAME@$HOST_NAME" -p "$PORT" "chmod +x /tmp/00.manual.setup-runner-linux-user.sh && sudo -S /tmp/00.manual.setup-runner-linux-user.sh"