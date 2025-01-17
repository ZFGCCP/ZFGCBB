# zfgc.com

Pizza.

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

This script displays the status of the specified namespace.

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

### Contributing

Feel free to contribute to the project by forking the repository, making changes, and submitting a pull request.

## Notes

TODO.
