#!/bin/bash
set -e

# Check if there are no arguments
if [ $# -eq 0 ]; then
    cat <<EOF
Usage: $0 <namespace>

Example: $0 zfgbb-develop
EOF
    exit 1
fi

ENVIRONMENT_TARGET=$1 || "zfgbb-develop"

SCRIPT_DIR=$(dirname "$0")
source "$SCRIPT_DIR/../common/check-minikube.sh"

check_minikube

kubectl describe deployments -n "$ENVIRONMENT_TARGET"

echo "Press any key to continue..."
read -n 1 -s
clear

kubectl describe services -n "$ENVIRONMENT_TARGET"

echo "Press any key to continue..."
read -n 1 -s
clear

kubectl describe pods -n "$ENVIRONMENT_TARGET"

echo "Press any key to continue..."
read -n 1 -s
clear