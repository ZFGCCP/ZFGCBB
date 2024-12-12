#!/bin/sh

set -e
set -o pipefail

if [ "$(id -u)" -ne 0 ]; then
    echo "Please run as root"
    exit 1
fi

DEBIAN_FRONTEND=noninteractive apt-get install --assume-yes apt-transport-https ca-certificates curl software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null
apt-get update

apt-cache policy docker-ce
DEBIAN_FRONTEND=noninteractive apt-get install --assume-yes docker-ce
