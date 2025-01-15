#!/bin/bash

# Ensure this script is sourced
if [ "${BASH_SOURCE[0]}" == "${0}" ]; then
    echo "This script is not meant to be executed directly. Please source it."
    exit 1
fi

check_minikube() {
    # Check if minikube is running
    MINIKUBE_STATUS=$(minikube status --format '{{.Host}}' || echo "")
    if [ "$MINIKUBE_STATUS" != "Running" ]; then
        echo "Minikube is not running. Starting minikube..."
        minikube start --driver=docker
        eval "$(minikube docker-env)"
        kubectl config use-context minikube
        docker compose build
    fi
}