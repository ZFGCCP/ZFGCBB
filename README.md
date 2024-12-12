# ZFGBB Backend

Bringin back the Drama Llama from the dead!

[![CI](https://github.com/ZFGCCP/ZFGCBB/actions/workflows/ci.yml/badge.svg)](https://github.com/ZFGCCP/ZFGCBB/actions/workflows/ci.yml)

## Table of Contents

- [ZFGBB Backend](#zfgbb-backend)
  - [Table of Contents](#table-of-contents)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
      - [Docker](#docker)
      - [Standing up just the database](#standing-up-just-the-database)
    - [Developing](#developing)
    - [Building](#building)
    - [Running Tests](#running-tests)
    - [Running MyBatis Generator](#running-mybatis-generator)
  - [License](#license)

## Getting Started

### Prerequisites

- [Docker/Docker-Compose](https://docs.docker.com/get-docker/)
- [Java 17](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- If running locally
  - [PostgreSQL](https://www.postgresql.org/download/)
  - [Tomcat](https://tomcat.apache.org/download-90.cgi)

#### Docker

Copy the `.env.example` file to `.env` and fill in the values, then run docker compose to start the containers.

```bash
cp .env.example .env
docker compose up -d
```

#### Standing up just the database

```bash
docker compuse up -d postgresql
```

### Developing

To run the application in development mode, run the following command:

```bash
mvn clean run package -Dmaven.test.skip=true
```

This will start the application in development mode, and you can access it at `http://localhost:8080`.

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
```

This will generate the MyBatis mappers and Java models based on the database schema.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
