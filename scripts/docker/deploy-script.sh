#!/bin/bash

set -e

log() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $*"
}

# Default values
TARGET_DIR="/opt/zfgbb"
DEPLOYMENT_PACKAGE="deployment-package.tar.gz"
ENV_FILE=".env.local"
BRANCH="main"
TAG=""

# Parse arguments
while [[ "$#" -gt 0 ]]; do
  case $1 in
    --dir) TARGET_DIR="$2"; shift ;;
    --package) DEPLOYMENT_PACKAGE="$2"; shift ;;
    --env) ENV_FILE="$2"; shift ;;
    --branch) BRANCH="$2"; shift ;;
    --tag) TAG="$2"; shift ;;
    *) echo "Unknown parameter: $1"; exit 1 ;;
  esac
  shift
done

log "Starting deployment process..."
log "Target directory: $TARGET_DIR"
log "Using deployment package: $DEPLOYMENT_PACKAGE"
log "Environment file: $ENV_FILE"
log "Branch: $BRANCH"
log "Tag (if any): $TAG"

# Authenticate with GHCR
GHCR_CREDENTIALS_FILE="$TARGET_DIR/ghcr.env"
if [ -f "$GHCR_CREDENTIALS_FILE" ]; then
  log "Authenticating with GitHub Container Registry..."
  export $(grep -v '^#' "$GHCR_CREDENTIALS_FILE" | xargs)
  echo "$GHCR_TOKEN" | docker login ghcr.io -u "$GHCR_USERNAME" --password-stdin
  rm -f "$GHCR_CREDENTIALS_FILE"
else
  log "Error: GHCR credentials file $GHCR_CREDENTIALS_FILE not found."
  exit 1
fi

# Check if target directory exists
if [ ! -d "$TARGET_DIR" ]; then
  log "Creating target directory: $TARGET_DIR"
  mkdir -p "$TARGET_DIR"
fi

log "Extracting deployment package..."
tar -xzf "$DEPLOYMENT_PACKAGE" -C "$TARGET_DIR" --strip-components=1

if [ ! -f "$TARGET_DIR/$ENV_FILE" ]; then
  log "Warning: Environment file $ENV_FILE not found. Using default values."
else
  log "Using environment file: $ENV_FILE"
fi

if docker compose -f "$TARGET_DIR/docker-compose.yml" ps &>/dev/null; then
  log "Stopping existing containers..."
  docker compose -f "$TARGET_DIR/docker-compose.yml" down -v
fi

log "Pulling latest docker images..."
cd "$TARGET_DIR"
docker compose pull

# Load env vars
for env_file in "$ENV_FILE" "version.env" ".env.docker"; do
  if [ -f "$env_file" ]; then
    export $(grep -v '^#' "$env_file" | xargs)
  fi
done

log "Starting containers..."
docker compose -f docker-compose.yml -f docker-compose.override.yml up -d

log "Checking container status..."
sleep 10
CONTAINERS_RUNNING=$(docker compose ps --format json | grep -c "running")
TOTAL_CONTAINERS=$(docker compose ps --format json | grep -c "service")

if [ "$CONTAINERS_RUNNING" -eq "$TOTAL_CONTAINERS" ]; then
  log "Deployment successful! All containers are running."
else
  log "Warning: Not all containers are running. Please check logs."
  docker compose logs
  exit 1
fi
