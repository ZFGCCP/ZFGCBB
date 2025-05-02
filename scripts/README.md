# ZFGBB Scripts

This directory contains scripts for various tasks related to the ZFGBB project.

## Table of Contents

- [ZFGBB Scripts](#zfgbb-scripts)
  - [Table of Contents](#table-of-contents)
  - [Folder Structure](#folder-structure)
    - [development - Local Only Development Scripts](#development---local-only-development-scripts)
    - [deployment - Deployment Scripts](#deployment---deployment-scripts)
    - [deployment/docker - Docker Scripts](#deploymentdocker---docker-scripts)

## Folder Structure

### [development](./development) - Local Only Development Scripts

This folder contains scripts that are only meant to be used locally, and not on the server.

- [development/setup.sh](./development/setup.sh) - A script to install dependencies for local development.
- [development/setup-deployment-keys.sh](./development/setup-deployment-keys.sh) - A script to set up SSH keys for deployment as a convinience.
- [development/deployment/bootstrap-server-for-deployment-automation.sh](./development/deployment/bootstrap-server-for-deployment-automation.sh) - A script to bootstrap a server for deployment automation.

### [deployment](./deployment) - Deployment Scripts

This folder contains scripts that are meant to be used on the server. Use `scp` to copy these scripts to the server, before running them.

- [deployment/00.manual.setup-runner-linux-user.sh](./deployment/00.manual.setup-runner-linux-user.sh) - A script to set up the runner user on the server.
- [deployment/01.provision-linode.sh](./deployment/01.provision-linode.sh) - A script to provision a Linode server. This script is also used by [.github/workflows/provision-linode.yml](./.github/workflows/provision-linode.yml).

### [deployment/docker](./deployment/docker) - Docker Scripts

This folder contains scripts that are meant to be used with Docker.

- [deployment/docker/build-docker-image.sh](./deployment/docker/build-docker-image.sh) - A script to build a Docker image.
- [deployment/docker/deploy-docker-image.sh](./deployment/docker/deploy-docker-image.sh) - A script to deploy a Docker image.