FROM maven:3.9-eclipse-temurin-17 AS build

RUN mkdir -p /usr/src/zfgcbb
COPY . /usr/src/zfgcbb

WORKDIR /usr/src/zfgcbb

RUN mvn clean compile package -Dmaven.test.skip=true -X

FROM tomcat:jre17-temurin-jammy AS deploy

COPY --from=build /usr/src/zfgcbb/target/*.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]