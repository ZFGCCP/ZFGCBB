# zfgc.com

Pizza.

## Table of Contents

- [zfgc.com](#zfgccom)
  - [Table of Contents](#table-of-contents)
  - [Environment Setup](#environment-setup)
  - [Development Process](#development-process)
    - [Scripts](#scripts)
      - [setup.sh](#setupsh)
      - [apply.sh](#applysh)
      - [status.sh](#statussh)
      - [destroy.sh](#destroysh)
  - [Workflow](#workflow)
    - [Cleaning Up](#cleaning-up)
  - [Workspace](#workspace)
    - [Domain Structure](#domain-structure)
  - [Notes](#notes)

## Environment Setup

To setup your environment, follow the [setup instructions](../README.md#setup) in the main README.

## Development Process

### Scripts

This project uses bash scripts to automate various tasks. Running the scripts requires the `bash` shell. Without passing any parameters, the scripts will display usage instructions.

#### [setup.sh](./scripts/development/setup.sh)

This script sets up the development environment for the project.

```bash
./scripts/development/setup.sh <project-directory> <environment>
```

#### [apply.sh](./scripts/development/apply.sh)

This script applies the manifests for the specified environment.

```bash
./scripts/development/apply.sh <project-directory> <environment>
```

#### [status.sh](./scripts/development/status.sh)

This script displays the status of the specified namespace. Namespaces are created by the [setup.sh](./scripts/development/setup.sh) script.

```bash
./scripts/development/status.sh <namespace>
```

#### [destroy.sh](./scripts/development/destroy.sh)

To destroy the development environment, run the following command:

```bash
./scripts/development/destroy.sh <project-directory> <environment>
```

## Workflow

The workflow for developing the application is as follows:

1. Run the [setup script](#setupsh) to configure the environment for `develop` environment.
   - `./scripts/development/setup.sh zfgc.com develop`
2. Run the [apply script](#applysh) to apply the manifests for the `develop` environment.
   - `./scripts/development/apply.sh zfgc.com develop`
  
You can check the status of the deployment using the [status script](#statussh):

```bash
./scripts/development/status.sh zfgc.com develop
```

### Cleaning Up

To clean up the development environment, run the following command:

```bash
./scripts/development/destroy.sh zfgc.com develop
```

## Workspace

The workspace is setup to group domains and services together.

### Domain Structure

```text
domain-name.tld
├── base - Defines the base resources for the domain, such as ingress and namespace.
│   ├── ingress.yml
│   ├── kustomization.yml
│   ├── namespace.yml
├── environments - Defines the environment configurations per git branch for the domain.
│   ├── [git-branch-name]
│   │   ├── kustomization.yml
│   │   ├── namespace.yml
│   ├── deployment-apache.yml
│   ├── deployment-mysql.yml
│   ├── deployment-postgres.yml
│   ├── deployment-zfgbb.yml
│   ├── kustomization.yml
│   ├── namespace.yml
│   ├── secret-mysql.yml
│   └── secret-postgres.yml
├── services - Defines the service manifests for the domain.
│   ├── [name]
│   │   ├── deployment-[name].yml
│   │   ├── kustomization.yml
│   │   ├── service-[name].yml
├── scripts
│   ├── setup-environment-files.sh
```

## Notes

Regarding the [Domain Structure](#domain-structure), for now, we're slightly breaking the convention and including `crystalrookarts` and legacy zfgc.com services under the `old-skool` service. This is because we're still using the old zfgc.com domain for legacy services, and we want to keep the domain name consistent. This will be addressed in the future. The [develop](./zfgc.com/)
