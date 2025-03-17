FROM adoptopenjdk/openjdk11:alpine-jre
RUN apt-get update
RUN apt-get install openjdk-11-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:11.0.16-slim

EXPOSE 8080

COPY --from=build target/Aciole-Contabilidade-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]