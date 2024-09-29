# ZFGBB Backend

Bringin back the Drama Llama from the dead!

## Table of Contents

- [ZFGBB Backend](#zfgbb-backend)
  - [Table of Contents](#table-of-contents)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
      - [Docker](#docker)
      - [Standing up just the database](#standing-up-just-the-database)

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
