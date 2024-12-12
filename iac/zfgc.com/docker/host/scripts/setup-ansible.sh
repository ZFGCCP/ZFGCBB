#!/bin/sh

set -e

if [ "$(id -u)" -ne 0 ]; then
    echo "Please run as root"
    exit 1
fi

apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install --assume-yes ansible