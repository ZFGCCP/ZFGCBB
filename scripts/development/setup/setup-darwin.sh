#!/bin/bash
set -e

if [ "$EUID" -ne 0 ]; then
    echo "Please run this script as root."
    exit 1
fi

brew update
echo "Do you want to install Docker Desktop? (y/n)"
read -r answer
if [ "$answer" == "y" ]; then
    echo "Installing Docker Desktop..."
    brew install docker docker-compose #minikube
else
    echo "Skipping installation of Docker Desktop."
fi

java_version=$(java -version 2>&1 | head -n 1 | awk -F '"' '{print $2}')
if [ "$java_version" != "17" ]; then
    echo "Java JDK 17 is not installed. Do you want to install it now? (y/n)"
    read -r answer
    if [ "$answer" == "y" ]; then
        echo "Installing Java JDK 17..."
        brew install openjdk@17
    else
        echo "Skipping installation of Java JDK 17."
    fi
fi

mvn --version > /dev/null 2>&1
if [ $? -ne 0 ]; then
    echo "mvn is not installed. Do you want to install it now? (y/n)"
    read -r answer
    if [ "$answer" == "y" ]; then
        echo "Installing mvn..."
        brew install maven
    else
        echo "Skipping installation of mvn."
    fi
fi
