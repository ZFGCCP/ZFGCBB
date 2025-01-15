#!/bin/bash
set -e

# Check if winget is installed
if ! command -v winget &> /dev/null; then
    echo "winget is not installed. Please install it first."
    exit 1
fi

# Check if we're running as admin
if [ "$(whoami)" != "Administrator" ]; then
    echo "Please run this script as an administrator."
    exit 1
fi

# Ask if we want to install WSL
wsl --list --quiet > /dev/null 2>&1
if [ $? -ne 0 ]; then
    echo "WSL is not installed. Do you want to install it now? (y/n)"
    read -r answer
    if [ "$answer" == "y" ]; then
        wsl --install
    fi
fi

echo "Do you want to install Docker Desktop, Kubernetes CLI, and Minikube? (y/n)"
read -r answer
if [ "$answer" == "y" ]; then
    echo "Installing Docker Desktop, Kubernetes CLI, and Minikube..."
    winget install -e --id Docker.DockerDesktop
    winget install -e --id Kubernetes.kubectl
    winget install -e --id Kubernetes.minikube
    minikube start --driver=docker
    eval "$(minikube docker-env)"
    kubectl config use-context minikube
else
    echo "Skipping installation of Docker Desktop, Kubernetes CLI, and Minikube."
fi

# Ask if we want to install Java JDK 17
java_version=$(java -version 2>&1 | head -n 1 | awk -F '"' '{print $2}')
if [ "$java_version" != "17" ]; then
    echo "Java JDK 17 is not installed. Do you want to install it now? (y/n)"
    read -r answer
    if [ "$answer" == "y" ]; then
        echo "Installing Java JDK 17..."
        winget install -e --id Eclipse.OpenJDK17
    else
        echo "Skipping installation of Java JDK 17."
    fi
fi

