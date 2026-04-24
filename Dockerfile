FROM maven:3.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app

COPY ./ ./

RUN mvn clean package

CMD ["java", "-jar", "/app/target/devops-0.0.1-SNAPSHOT.jar"]
