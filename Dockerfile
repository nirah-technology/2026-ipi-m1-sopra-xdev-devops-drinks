FROM maven:3.9-eclipse-temurin-21-alpine AS builder

WORKDIR /app

# Création de l'utilisateur spring
RUN addgroup -S spring && adduser -S spring -G spring
USER spring

# NON COMPLIANT
# COPY ./ ./

# COMPLIANT
COPY ./pom.xml ./
COPY ./src ./

RUN mvn clean package
RUN chown -R spring:spring /app

CMD ["java", "-jar", "/app/target/devops-0.0.1-SNAPSHOT.jar"]
