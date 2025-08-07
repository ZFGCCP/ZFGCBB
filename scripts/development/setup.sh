#!/bin/bash
set -e

# Check what OS we're running on
OS=$(uname -s)

SCRIPT_DIR=$(dirname "$0")

# Source the setup function for the current OS
if [ "$OS" == "Linux" ]; then
    source "$SCRIPT_DIR/setup/setup-linux.sh"
elif [ "$OS" == "Darwin" ]; then
    source "$SCRIPT_DIR/setup/setup-macos.sh"
else
    source "$SCRIPT_DIR/setup/setup-windows.sh"
fi
