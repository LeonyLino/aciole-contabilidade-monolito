FROM maven:3.8.7-eclipse-temurin-11 AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:11.0.16-slim

WORKDIR /app
COPY --from=build /app/target/Aciole-Contabilidade-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
