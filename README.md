# ZFGBB Backend

Bringin back the Drama Llama from the dead!

[![CI](https://github.com/ZFGCCP/ZFGCBB/actions/workflows/ci.yml/badge.svg)](https://github.com/ZFGCCP/ZFGCBB/actions/workflows/ci.yml)

## Table of Contents

- [ZFGBB Backend](#zfgbb-backend)
  - [Table of Contents](#table-of-contents)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
      - [Setup](#setup)
    - [Developing with an IDE](#developing-with-an-ide)
      - [Visual Studio Code](#visual-studio-code)
      - [Eclipse](#eclipse)
    - [Developing Standalone](#developing-standalone)
    - [Building](#building)
    - [Running Tests](#running-tests)
    - [Running MyBatis Generator](#running-mybatis-generator)
  - [IaC (Infrastructure as Code)](#iac-infrastructure-as-code)
  - [License](#license)

## Getting Started

### Prerequisites

- [Git Bash](https://git-scm.com/downloads)
- [Docker/Docker-Compose](https://docs.docker.com/get-docker/)
- [Java 17](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- If running locally
  - [PostgreSQL](https://www.postgresql.org/download/)
  - [Tomcat](https://tomcat.apache.org/)

#### Setup

To use the automatic setup script to download and install dependencies, make sure [Git Bash](https://git-scm.com/downloads) is installed. This script currently supports Windows, macOS, and Linux.

This repository provides a [setup script](./scripts/development/setup.sh). It will automatically detect your environment and prompt you to install dependencies. For Linux, only two kinds of distros are handled for installing packages (Arch and Ubuntu). For any other Linux distro, the script will just check the presence of dependencies.

Using the script can be done by invoking the following command.

```bash
./scripts/development/setup.sh
```

### Developing with an IDE

Opening the project in Eclipse or Visual Studio Code is recommended.

Stand up the database using the following command.

```bash
docker-compose up -d postgresql pgadmin
```

You can access pgadmin at `http://0.0.0.0:5050`.

#### Visual Studio Code

The [vscode settings](./.vscode/settings.json) provides a basic setup for developing with VS Code.

The following build actions are available:

- `Debug Backend`: Runs the backend in debug mode, using `.env.local` as the environment file. NOTE: Docker should resolve just fine, but if not you can use the (Docker) variant of this action.
- `Debug Backend (Docker)`: Runs the backend in debug mode, using `.env.docker` as the environment file.

#### Eclipse

Eclipse will respect the applications.properties file, so you can use that to configure the application.

### Developing Standalone

To run the application in development mode, run the following command:

```bash
mvn clean run package -Dmaven.test.skip=true
```

This will start the application in development mode, and you can access it at `http://0.0.0.0:8080`.

### Building

To build the application, run the following command:

```bash
mvn clean compile package -Dmaven.test.skip=true
```

This will create a `.war` file in the `target` directory.

### Running Tests

To run the tests, run the following command:

```bash
mvn test
```

This will run all the tests in the [src/test](src/test) directory.

### Running MyBatis Generator

To run the MyBatis generator, run the following command:

```bash
nvm mybatis-generator:generate
```

This will generate the MyBatis mappers and Java models based on the database schema.

## IaC (Infrastructure as Code)

We implement a [Kubernetes Project](./iac/) to deploy the application to a Kubernetes cluster. This also contains configuration for the legacy zfgc.com environment under the `old-skool` service. More details can be found in the [IaC README](./iac/).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
