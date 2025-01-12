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

## Deployment Process

### Deploying Locally with minikube

Run the following command to start minikube:

```bash
./iac/zfgc.com/scripts/start-minikube.sh

./iac/zfgc.com/scripts/setup-test.sh
```

## Notes

- **Customizing Values**:
  Modify `kustomize.env` and environment-specific overlays as needed for different settings.
  
- **Service Endpoints**:
  Verify networking settings to ensure appropriate service access.

- **Troubleshooting**:
  Check logs using `kubectl logs` for any deployment-related issues.

## Contributions

Feel free to contribute to the project by forking the repository, making changes, and submitting a pull request.

## License

This project is licensed under the MIT License.
