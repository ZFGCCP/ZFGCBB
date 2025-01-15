#!/bin/bash
set -e

# Check distro
if [ "$(lsb_release -si)" == "Ubuntu" ]; then
    # Check if we're running as root
    if [ "$EUID" -ne 0 ]; then
        echo "Please run this script as root."
        exit 1
    fi

    sudo apt-get update
    # Install dependencies
    # Install Docker, Docker Compose, and Minikube
    sudo apt-get install -y docker.io docker-compose minikube openjdk-17-jdk

    echo "Docker installed successfully."
# Else if we're running on Arch Linux
elif [ "$(lsb_release -si)" == "Arch" ]; then
    sudo pacman -Syu
    sudo pacman -S docker docker-compose minikube openjdk17-jdk
else 
    # Just check if there are missing dependencies, then list them out
    if ! command -v docker &> /dev/null; then
        echo "Docker is not installed. Please install it first."
    fi
    if ! command -v kubectl &> /dev/null; then
        echo "Kubernetes CLI is not installed. Please install it first."
    fi
    if ! command -v minikube &> /dev/null; then
        echo "Minikube is not installed. Please install it first."
    fi
    if ! command -v java &> /dev/null; then
        echo "Java JDK 17 is not installed. Please install it first."
    else
        java_version=$(java -version 2>&1 | head -n 1 | awk -F '"' '{print $2}')
        if [ "$java_version" != "17" ]; then
            echo "Java JDK 17 is not installed. Please install it first."
        fi
    fi
    exit 0
fi

echo "Starting Docker..."
sudo systemctl start docker
echo "Docker started successfully."
echo "Installing Minikube..."
curl -LO https://github.com/kubernetes/minikube/releases/latest/download/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64
echo "Minikube installed successfully."

minikube start --driver=docker
eval "$(minikube docker-env)"
kubectl config use-context minikube
