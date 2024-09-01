FROM maven:3.8.1-openjdk-17 AS build

RUN mkdir -p /usr/src/zfgcbb

WORKDIR /usr/src/zfgcbb

COPY . .

RUN mvn clean package -Dmaven.test.skip=true

FROM tomcat:latest AS deploy

RUN mkdir -p /usr/src/zfgcbb

COPY --from=build /usr/src/zfgcbb/target/zfgbb.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]