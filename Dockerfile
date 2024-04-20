FROM openjdk:21-jdk-slim AS base
LABEL authors="isifoo"

RUN apt-get update && apt-get upgrade -y

WORKDIR .
COPY ./target/app.jar .
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]