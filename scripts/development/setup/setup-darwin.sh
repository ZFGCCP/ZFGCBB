#!/bin/bash
set -e

# Check if we're running as root
if [ "$EUID" -ne 0 ]; then
    echo "Please run this script as root."
    exit 1
fi

brew update
brew install docker docker-compose minikube openjdk@17 
