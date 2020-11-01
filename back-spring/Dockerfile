# build
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /src
COPY pom.xml /pom.xml
RUN mvn -f /pom.xml clean package

# copy
FROM openjdk:8-jre-alpine
COPY target/TravelBridge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
