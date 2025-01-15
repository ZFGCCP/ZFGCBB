#!/bin/bash
set -e

# Check if there are no arguments
if [ $# -eq 0 ]; then
    cat <<EOF
Usage: $0 <project-directory> <environment>

Example: $0 "./zfgc.com" "development"
EOF
    exit 1
fi

PROJECT_DIR=$(realpath "$1")
PROJECT_ENVIRONMENT=$2

SOURCE_DIR=$(dirname "$0")
source "$SOURCE_DIR/../common/check-minikube.sh"

check_minikube

kustomize build "$PROJECT_DIR/environments/$PROJECT_ENVIRONMENT" | kubectl delete -f -
