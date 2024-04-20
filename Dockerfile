FROM openjdk:18-jdk-slim
LABEL authors="isifoo"

WORKDIR /app
COPY ./target/real_estate_management-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080

CMD ["java", "-jar", "real_estate_management-0.0.1-SNAPSHOT.jar"]