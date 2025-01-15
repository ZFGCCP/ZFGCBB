#!/bin/bash
set -e

INSTALL_IAC_STUFF=false
INSTALL_JAVA_STUFF=false

# Ask if we want to install IAC stuff
echo "Do you want to install Docker, Docker Compose, and Minikube? (y/n)"
read -r answer
if [ "$answer" == "y" ]; then
    INSTALL_IAC_STUFF=true
fi

# Ask if we want to install Java stuff
echo "Do you want to install Java JDK 17? (y/n)"
read -r answer
if [ "$answer" == "y" ]; then
    INSTALL_JAVA_STUFF=true
fi

install_ubuntu() {
    sudo apt-get update
    # Install dependencies
    if [ "$INSTALL_IAC_STUFF" = true ]; then
        # Install Docker, Docker Compose, and Minikube
        sudo apt-get install -y docker.io docker-compose minikube
    fi

    if [ "$INSTALL_JAVA_STUFF" = true ]; then
        # Install Java JDK 17
        sudo apt-get install -y openjdk-17-jdk
    fi
}

install_arch() {
    sudo pacman -Syu
    if [ "$INSTALL_IAC_STUFF" = true ]; then
        # Install Docker, Docker Compose, and Minikube
        sudo pacman -S docker docker-compose minikube
    fi

    if [ "$INSTALL_JAVA_STUFF" = true ]; then
        # Install Java JDK 17
        sudo pacman -S openjdk17-jdk
    fi
}

install_unknown() {
    echo "We don't know your distro. So, we'll just check the presence of the dependencies."

    # Just check if there are missing dependencies, then list them out
    if [ "$INSTALL_IAC_STUFF" = true ]; then
        if ! command -v docker &> /dev/null; then
            echo "Docker is not installed. Please install it first."
        fi
        if ! command -v kubectl &> /dev/null; then
            echo "Kubernetes CLI is not installed. Please install it first."
        fi
        if ! command -v minikube &> /dev/null; then
            echo "Minikube is not installed. Please install it first."
        fi
    fi
    
    if [ "$INSTALL_JAVA_STUFF" = true ]; then
        if ! command -v java &> /dev/null; then
            echo "Java JDK 17 is not installed. Please install it first."
        else
            java_version=$(java -version 2>&1 | head -n 1 | awk -F '"' '{print $2}')
            if [ "$java_version" != "17" ]; then
                echo "Java JDK 17 is not installed. Please install it first."
            fi
        fi
    fi

    exit 0
}

# Check distro
if [ "$(lsb_release -si)" == "Ubuntu" ]; then
    install_ubuntu
# Else if we're running on Arch Linux
elif [ "$(lsb_release -si)" == "Arch" ]; then
    install_arch
else 
    install_unknown
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
