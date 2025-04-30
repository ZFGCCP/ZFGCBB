#!/bin/bash

set -e

# Log function
log() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $*"
}

log "Starting Linux user setup..."

# Ensure we're running as root
if [ "$(id -u)" -ne 0 ]; then
  log "This script must be run as root"
  exit 1
fi

RUNNER_USER=${RUNNER_USER:-zfgbb}

# Create user if it doesn't exist
if ! id -u "$RUNNER_USER" > /dev/null 2>&1; then
  log "Creating user '$RUNNER_USER'..."
  useradd --create-home --shell /bin/bash "$RUNNER_USER"
else
  log "User '$RUNNER_USER' already exists"
fi

# Set up sudoers if it doesn't exist
if [ ! -f "/etc/sudoers.d/$RUNNER_USER" ]; then
  log "Creating sudoers entry for user '$RUNNER_USER'..."
  echo "$RUNNER_USER ALL=(ALL) NOPASSWD:ALL" > "/etc/sudoers.d/$RUNNER_USER"
else
  log "sudoers entry for user '$RUNNER_USER' already exists"
fi

# Set up SSH keys if they don't exist
SSH_DIR="/home/$RUNNER_USER/.ssh"
if [ ! -d "$SSH_DIR" ]; then
  log "Creating SSH directory '$SSH_DIR'..."
  mkdir -p "$SSH_DIR"
  ssh-keygen -t rsa -b 4096 -f $SSH_DIR/id_rsa -q -N ""
  chmod 600 "$SSH_DIR/id_rsa"
  chown -R "$RUNNER_USER:$RUNNER_USER" "$SSH_DIR"
  mv "$SSH_DIR/id_rsa.pub" "$SSH_DIR/authorized_keys"
  chmod 600 "$SSH_DIR/authorized_keys"

  mv "$SSH_DIR/id_rsa" "/home/$RUNNER_USER/id_rsa.bak"
  log "SSH keys have been generated and stored in '$SSH_DIR'. You can find them in your home directory."
  log "Please configure the SSH private key in your GitHub repository settings."
  cat "/home/$RUNNER_USER/id_rsa.bak"
else
  log "SSH directory '$SSH_DIR' already exists"
fi

# Check if SSH has passwords disabled, if not then disable it, and make sure public key authentication is enabled
if grep -q "PasswordAuthentication no" "/etc/ssh/sshd_config"; then
  log "SSH password authentication is disabled. Enabling..."
  sed -i 's/PasswordAuthentication no/PasswordAuthentication yes/' /etc/ssh/sshd_config
  systemctl restart ssh
fi

if grep -q "PubkeyAuthentication no" "/etc/ssh/sshd_config"; then
  log "SSH public key authentication is disabled. Enabling..."
  sed -i 's/PubkeyAuthentication no/PubkeyAuthentication yes/' /etc/ssh/sshd_config
  systemctl restart ssh
fi

# We need to search /etc/ssh/sshd_config for "AuthorizedKeysFile      .ssh/authorized_keys". If this is not present, find the line that matches "AuthorizedKeysFile" and all preceding whitespace or characters on the same line, and replace it with "AuthorizedKeysFile      .ssh/authorized_keys"
if ! grep -q "AuthorizedKeysFile      .ssh/authorized_keys" "/etc/ssh/sshd_config"; then
  log "AuthorizedKeysFile is not set in /etc/ssh/sshd_config. Setting it to .ssh/authorized_keys..."
  sed -i 's/^AuthorizedKeysFile/AuthorizedKeysFile      .ssh\/authorized_keys/' /etc/ssh/sshd_config
fi

log "Linux user setup completed successfully!"
