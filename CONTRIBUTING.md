# Contributing

When contributing to this repository, please first discuss the change you wish to make via issue,
email, or any other method with the owners of this repository before making a change.

Please note we have a code of conduct, please follow it in all your interactions with the project.

TBD. We could use some help writing this out.

## Table of Contents

- [Contributing](#contributing)
  - [Table of Contents](#table-of-contents)
  - [Development](#development)
    - [Prerequisites](#prerequisites)
      - [Using the scripts/development/setup.sh script](#using-the-scriptsdevelopmentsetupsh-script)
        - [Configuring the `.env` file](#configuring-the-env-file)
    - [IDEs](#ides)
      - [Visual Studio Code](#visual-studio-code)
      - [Eclipse](#eclipse)
    - [Developing Standalone](#developing-standalone)
    - [Building](#building)
    - [Running Tests](#running-tests)
    - [Running MyBatis Generator](#running-mybatis-generator)
    - [Docker](#docker)
      - [Example Usages of Docker](#example-usages-of-docker)
    - [Workflow - Typical Development Workflow](#workflow---typical-development-workflow)

## Development

TBD.

### Prerequisites

Clone the repository.

```bash
git clone https://github.com/ZFGC/ZFGCBB.git
```

- Java 17
- Maven
- Docker

#### Using the [scripts/development/setup.sh](./scripts/development/setup.sh) script

The development setup script is just a helper script to download and install all the required dependencies. You can optionally manually install the dependencies if you prefer.

```bash
./scripts/development/setup.sh
```

The script will run depending on your OS, which the following below are supported.

- Windows 10/11
- Mac OSX
- Linux
  - Ubuntu
  - Arch Linux

##### Configuring the `.env` file

The `.env` file is used to configure the application. You will need to supply values for CLAUSIUS_AUTH_KEY, CLAUSIUS_CLIENT, CLAUSIUS_PASSWORD, and CLAUSIUS_AUTH_ENDPOINT.

Please reach out to the Steven the Hutt aka MG-Zero to get these values.

### IDEs

The project is configured to work with the following IDEs.

- [Eclipse](https://www.eclipse.org/)
- [VSCode](https://code.visualstudio.com/)

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

### Docker

You can use Docker to run the application locally, and to standup a postgres instance in a container. This repository implements a [docker-compose.yml](./docker-compose.yml) file to stand up the database and the application, with the following services:

- `postgresql`: Stands up a PostgreSQL database.
- `pgadmin`: Stands up a pgadmin instance to manage the database.
- `api`: Stands up the application.

To stand up the database and the application, run the following command:

```bash
docker compose up -d
```

You can access the application at `http://0.0.0.0:8080`.

You can access pgadmin at `http://0.0.0.0:5050`.

View the logs using `docker compose logs -f`, or for a specific service (i.e. postgresql) `docker compose logs -f zfgbb_postgresql`.

To stop the application, run the following command:

```bash
docker compose down -v
```

We pass the `-v` flag to the `down` command to remove the volumes.

#### Example Usages of Docker

- Run the application in debug mode on your machine.
  1. Run the following command to start the postgres database.
     ```bash
     docker compose up -d postgresql
     ```
  2. Use the `Debug Backend` action in VSCode to start the application in debug mode.

### Workflow - Typical Development Workflow

1. Read the [Code of Conduct](CODE_OF_CONDUCT.md).
2. If you are not part of the ZFGCCP organization, you will need to fork this repository.
3. Make sure you are on the `development` branch. `git switch development && git pull`.
4. Make a new branch for your changes. `git switch -c my-new-branch`.
   1. How do I name my branch? See the next section, we have some recommendations, but we don't have any official rules so you can use whatever naming convention you prefer for your branch.
   2. Brach Naming Conventions (General Recommendations)
      1. If you are working on a new feature, you can name your branch `feature/my-new-feature`.
      2. If you are working on a bug fix, you can name your branch `bugfix/my-bug-fix` or `fix/my-bug-fix`.
      3. If you are working on a documentation change, you can name your branch `docs/my-docs-change`.
      4. If you are working on a refactor, you can name your branch `refactor/my-refactor`.
      5. If you are working on a test, you can name your branch `test/my-test`.
      6. You are ready to start working on your branch!
5. Working on your changes: Use your IDE of choice to edit files and save changes.
   1. TBD add instructions.
   5. Stage and commit your changes.
   6. Push your changes to your branch on GitHub.
6. [Create a new pull request](https://github.com/ZFGCCP/ZFGCBB-React/compare) and request a review from one of the maintainers.
   1. Add a bullet point list of changes you made.
   2. Mention the issue number you are working on.
      1. If there is no issue, you can create one.
   3. Title the pull request using conventional commits, with `closes #issue-number` included, if applicable.
      1. Example: `feat: add new feature`
      2. See: <https://www.conventionalcommits.org/en/v1.0.0/>
   4. For the duration of your pull request, please keep your branch up to date with the `development` branch.
   5. Your PR must pass all checks before it can be merged or requested for review.
7. As Sonic the Hedgehog says, "Gotta go fast!". And you went fast! Congratulations on making a contribution to the project!
