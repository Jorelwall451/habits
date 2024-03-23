FROM maven:3.6.3-openjdk-17
LABEL authors="jorelwall154"

WORKDIR /habits/

COPY src .
COPY .env .
COPY pom.xml .

RUN mvn package

COPY target/habits-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]