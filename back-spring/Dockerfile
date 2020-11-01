# # build
# FROM maven:3.6.0-jdk-11-slim AS build
# COPY src /home/app/src
# COPY pom.xml /home/app
# RUN mvn -f /home/app/pom.xml clean package

# # copy
FROM openjdk:8-jre-alpine
COPY target/TravelBridge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
# FROM openjdk:8-jdk-alpine
# VOLUME /tmp
# EXPOSE 8081
# COPY target/TravelBridge-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java", "-jar", "app.jar"]
