FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /usr/src
ADD ./mvn* ./
ADD ./pom.xml ./
ADD ./src ./src

RUN mvn clean compile package -Dmaven.test.skip=true

# FIXME: This image should be switched to gcr.io/distroless/java-base-debian12 because it is much smaller. For now, this will work.
FROM tomcat:jre17-temurin-jammy AS deploy

COPY --from=build /usr/src/target/*.war /usr/local/tomcat/webapps/

EXPOSE ${ZFGBB_BACKEND_PORT:-8080}

CMD ["catalina.sh", "run"]

FROM postgres:16 AS database

ADD ./scripts/sql/provisioning/1-zfgbb.initialize-database.sh /docker-entrypoint-initdb.d/1-zfgbb.initialize-database.sh

# We exclude .sql from the file name so that it gets ignored by the init script.
ADD ./scripts/sql/provisioning/2-provision-database.sql /docker-entrypoint-initdb.d/2-provision-database 