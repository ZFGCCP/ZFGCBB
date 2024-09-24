FROM maven:3.9-eclipse-temurin-17 AS build

RUN mkdir -p /usr/src/zfgcbb
COPY . /usr/src/zfgcbb

WORKDIR /usr/src/zfgcbb

RUN mvn clean compile package -Dmaven.test.skip=true

FROM postgres:16 AS database

#RUN echo "CREATE DATABASE zfgcbb; CREATE USER $SPRING_DATASOURCE_USERNAME; GRANT ALL PRIVILEGES ON DATABASE zfgcbb TO $SPRING_DATASOURCE_USERNAME;" > /docker-entrypoint-initdb.d/init.sql

FROM tomcat:jre17-temurin-jammy AS deploy

COPY --from=build /usr/src/zfgcbb/target/*.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]