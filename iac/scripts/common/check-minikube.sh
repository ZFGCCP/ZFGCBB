#!/bin/bash

check_minikube() {
    # Check if minikube is running
    MINIKUBE_STATUS=$(minikube status --format '{{.Host}}' || echo "")
    if [ "$MINIKUBE_STATUS" != "Running" ]; then
        echo "Minikube is not running. Starting minikube..."
        minikube start --driver=docker
        eval $(minikube docker-env)
        kubectl config use-context minikube
        docker compose build
    fi
}