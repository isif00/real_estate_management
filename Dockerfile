FROM openjdk:18-jdk-slim
LABEL authors="isifoo"

WORKDIR /app
COPY ./target/app.jar /app
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]