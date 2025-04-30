#!/bin/bash

# --- Usage Help ---
usage() {
  echo "Usage: $0 -a HOST_ALIAS -h HOST_NAME -u USER -k IDENTITY_FILE"
  echo ""
  echo "  -a HOST_ALIAS      Alias for SSH config (e.g., linode)"
  echo "  -h HOST_NAME       Hostname or IP address (e.g., 192.0.2.10)"
  echo "  -u USER            SSH username (e.g., root)"
  echo "  -k IDENTITY_FILE   Path to your private SSH key (e.g., ~/.ssh/linode_key)"
  echo ""
  echo "Example:"
  echo "  $0 -a linode -h 192.0.2.10 -u root -k ~/.ssh/linode_key"
  exit 1
}

# --- Parse Arguments ---
while getopts ":a:h:u:k:" opt; do
  case $opt in
    a) HOST_ALIAS="$OPTARG" ;;
    h) HOST_NAME="$OPTARG" ;;
    u) USER_NAME="$OPTARG" ;;
    k) IDENTITY_FILE="$OPTARG" ;;
    *) usage ;;
  esac
done

# --- Check for required arguments ---
if [[ -z "$HOST_ALIAS" || -z "$HOST_NAME" || -z "$USER_NAME" || -z "$IDENTITY_FILE" ]]; then
  usage
fi

# --- Expand tilde manually if used in path ---
IDENTITY_FILE="${IDENTITY_FILE/#\~/$HOME}"

# --- Check if identity file exists ---
if [ ! -f "$IDENTITY_FILE" ]; then
  echo "❌ Error: Identity file '$IDENTITY_FILE' does not exist."
  exit 1
fi

SSH_CONFIG="$HOME/.ssh/config"

# --- Backup the current SSH config file before modifying it ---
if [ -f "$SSH_CONFIG" ]; then
  cp "$SSH_CONFIG" "$SSH_CONFIG.bak"
  echo "✅ Backup of existing SSH config created at $SSH_CONFIG.bak"
else
  echo "⚠️ No existing SSH config found. A new config will be created."
fi

# --- Check if HOST_NAME is an IP address ---
if [[ "$HOST_NAME" =~ ^[0-9]+\.[0-9]+\.[0-9]+\.[0-9]+$ ]]; then
  # It's an IP address, use the IP as the alias
  HOST_ALIAS="$HOST_NAME"
  HOSTNAME_LINE=""
else
  # It's a hostname, add HostName to config
  HOSTNAME_LINE="    HostName $HOST_NAME"
fi

# --- Define the separator lines for the host alias ---
START_SEPARATOR="# BEGIN $HOST_ALIAS"
END_SEPARATOR="# END $HOST_ALIAS"

# --- Remove any existing configuration for this host alias using the separators ---
sed -i "/$START_SEPARATOR/,/$END_SEPARATOR/d" "$SSH_CONFIG"

# --- Append new configuration for the host alias ---
echo "➕ Adding or replacing entry for '$HOST_ALIAS' in SSH config..."

cat <<EOF >> "$SSH_CONFIG"

$START_SEPARATOR
Host $HOST_ALIAS
$HOSTNAME_LINE
    User $USER_NAME
    IdentityFile $IDENTITY_FILE
    IdentitiesOnly yes
$END_SEPARATOR
EOF

echo "✅ New entry for '$HOST_ALIAS' added or replaced."
