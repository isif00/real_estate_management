FROM ubuntu:latest AS build
LABEL authors="isifoo"
RUN apt-get update && apt-get upgrade -y
RUN apt-get install openjdk-21-jdk -y
WORKDIR /app
COPY . ./app
COPY ./target/real_estate_management-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "real_estate_management-0.0.1-SNAPSHOT.jar"]

FROM openjdk:21-jdk-slim
EXPOSE 8080
