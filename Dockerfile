FROM openjdk:18-jdk-slim
LABEL authors="isifoo"

WORKDIR /app
COPY . /app
EXPOSE 8080
CMD ["ls", "-la"]
CMD ["java", "-jar", "target/app.jar"]