FROM maven:3-jdk-8-alpine as builder
VOLUME /tmp
VOLUME /var/log

ARG JAR_FILE=target/testing-framework-be.jar

WORKDIR /app
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]