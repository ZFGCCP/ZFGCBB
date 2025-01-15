#!/bin/bash
set -e

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