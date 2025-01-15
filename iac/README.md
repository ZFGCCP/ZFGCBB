# zfgc.com

Pizza.

## Environment Setup

### Install Dependencies

   ```bash
   cd iac/zfgc.com
   ./scripts/bootstrap.sh
   ```

1. **Docker**: Ensure Docker is installed to build/test containers locally - [Get Docker](https://docs.docker.com/get-docker/).

### Project Configuration

1. **Secrets Management**:
   - Store sensitive data like database passwords securely.
   - Add MySQL and PostgreSQL passwords as secrets in your GitHub repository:

     - **MySQL Password**: Under `Settings > Secrets and variables > Actions > New repository secret`.
       - Name: `MYSQL_PASSWORD`
       - Value: Your MySQL password.

     - **PostgreSQL Password**: Under `Settings > Secrets and variables > Actions > New repository secret`.
       - Name: `POSTGRES_PASSWORD`
       - Value: Your PostgreSQL password.

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

## Notes

TODO.

## Contributions

Feel free to contribute to the project by forking the repository, making changes, and submitting a pull request.

## License

This project is licensed under the MIT License.
