#!/bin/bash

set -e

# Log function
log() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $*"
}

log "Starting Linode provisioning..."

# Update package lists if it hasn't been updated in the last 12 hours
APT_UPDATE_TIMESTAMP="/var/lib/apt/periodic/update-success-stamp"
if [ ! -f "$APT_UPDATE_TIMESTAMP" ] || [ "$(find "$APT_UPDATE_TIMESTAMP" -mtime +0.5 2>/dev/null)" ]; then
  log "Updating package lists..."
  sudo apt update
else
  log "Package lists already up to date"
fi

# Install required packages if not already installed
PACKAGES_TO_INSTALL="apt-transport-https curl containerd docker.io docker-compose-v2"
PACKAGES_TO_INSTALL_ARR=($PACKAGES_TO_INSTALL)

PACKAGES_TO_INSTALL_FILTERED=""
for pkg in "${PACKAGES_TO_INSTALL_ARR[@]}"; do
  if ! dpkg -l | grep -q "^ii\s*$pkg"; then
    PACKAGES_TO_INSTALL_FILTERED="$PACKAGES_TO_INSTALL_FILTERED $pkg"
  fi
done

if [ -n "$PACKAGES_TO_INSTALL_FILTERED" ]; then
  log "Installing packages: $PACKAGES_TO_INSTALL_FILTERED"
  sudo apt install -y $PACKAGES_TO_INSTALL_FILTERED
else
  log "All required packages already installed"
fi

# Configure containerd if not already configured
if [ ! -f "/etc/containerd/config.toml" ] || ! grep -q "SystemdCgroup = true" "/etc/containerd/config.toml"; then
  log "Configuring containerd..."
  sudo mkdir -p /etc/containerd
  sudo containerd config default | sudo tee /etc/containerd/config.toml > /dev/null
  sudo sed -i 's/SystemdCgroup = false/SystemdCgroup = true/' /etc/containerd/config.toml
  sudo systemctl restart containerd
else
  log "containerd already configured"
fi

# Create app directory structure if it doesn't exist
APP_DIR="/opt/zfgbb"
if [ ! -d "$APP_DIR" ]; then
  log "Creating application directory structure..."
  sudo mkdir -p "$APP_DIR"
  sudo mkdir -p "$APP_DIR/data"
  sudo mkdir -p "$APP_DIR/config"
  sudo mkdir -p "$APP_DIR/logs"
  sudo chown -R $(whoami):$(whoami) "$APP_DIR"
else
  log "Application directory structure already exists"
fi

# Set up docker group and add user
if ! getent group docker > /dev/null; then
  log "Creating docker group..."
  sudo groupadd docker
fi

if ! groups $(whoami) | grep -q '\bdocker\b'; then
  log "Adding user to docker group..."
  sudo usermod -aG docker $(whoami)
  log "You may need to log out and back in for group changes to take effect"
fi

# Ensure docker service is enabled and running
if ! systemctl is-enabled docker.service > /dev/null 2>&1; then
  log "Enabling docker service..."
  sudo systemctl enable docker.service
fi

if ! systemctl is-active docker.service > /dev/null 2>&1; then
  log "Starting docker service..."
  sudo systemctl start docker.service
else
  log "Docker service already running"
fi

log "Linode provisioning completed successfully!"