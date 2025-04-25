#!/bin/bash
set -e

INSTALL_IAC_STUFF=false
INSTALL_JAVA_STUFF=false

echo "Do you want to install Docker, Docker Compose, and Minikube? (y/n)"
read -r answer
if [ "$answer" == "y" ]; then
    INSTALL_IAC_STUFF=true
fi

echo "Do you want to install Java JDK 17? (y/n)"
read -r answer
if [ "$answer" == "y" ]; then
    INSTALL_JAVA_STUFF=true
fi

install_ubuntu() {
    sudo apt-get update
    if [ "$INSTALL_IAC_STUFF" = true ]; then
        sudo apt-get install -y docker.io docker-compose minikube
    fi

    if [ "$INSTALL_JAVA_STUFF" = true ]; then
        sudo apt-get install -y openjdk-17-jdk maven
    fi
}

install_arch() {
    sudo pacman -Syu
    if [ "$INSTALL_IAC_STUFF" = true ]; then
        sudo pacman -S docker docker-compose minikube 
    fi

    if [ "$INSTALL_JAVA_STUFF" = true ]; then
        sudo pacman -S openjdk17-jdk maven
    fi
}

install_unknown() {
    echo "We don't know your distro. So, we'll just check the presence of the dependencies."

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

        if ! command -v mvn &> /dev/null; then
            echo "mvn is not installed. Please install it first."
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

#grab cpu arch for minikube
cpu_arch=$(uname -m)

if [ "$cpu_arch" == "x86_64" ]; then
    cpu_arch="amd64"
elif [ "$cpu_arch" == "aarch64" ]; then
    cpu_arch="arm64"
else
    echo "Unknown CPU architecture. Please install Minikube manually."
    exit 1
fi

curl -LO https://github.com/kubernetes/minikube/releases/latest/download/minikube-linux-amd64
sudo install minikube-linux-$cpu_arch /usr/local/bin/minikube && rm minikube-linux-$cpu_arch
echo "Minikube installed successfully."

minikube start --driver=docker
eval "$(minikube docker-env)"
kubectl config use-context minikube
