FROM maven:3.9-eclipse-temurin-17-alpine AS build
WORKDIR /app

COPY pom.xml mvnw* ./
COPY .mvn .mvn
COPY src src

RUN ./mvnw clean package -DskipTests

FROM gcr.io/distroless/java17-debian12
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Spring Boot runs on 8080 by default — can override via env
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]



FROM postgres:16-alpine AS database
ADD ./scripts/sql/provisioning/1-zfgbb.initialize-database.sh /docker-entrypoint-initdb.d/1-zfgbb.initialize-database.sh
# We exclude .sql from the file name so that it gets ignored by the init script.
ADD ./scripts/sql/provisioning/2-provision-database.sql /docker-entrypoint-initdb.d/2-provision-database