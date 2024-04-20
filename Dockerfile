FROM openjdk:21-jdk-slim AS base
LABEL authors="isifoo"

RUN apt-get update && apt-get upgrade -y

WORKDIR .
COPY ./target/real_estate_management-0.0.1-SNAPSHOT.jar .
EXPOSE 8080

CMD ["java", "-jar", "real_estate_management-0.0.1-SNAPSHOT.jar"]