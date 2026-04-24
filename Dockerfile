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

RUN chown -R spring:spring /app \ 
    && mvn clean package

CMD ["java", "-jar", "/app/target/devops-0.0.1-SNAPSHOT.jar"]
