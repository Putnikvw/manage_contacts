FROM openjdk:13-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
WORKDIR /target
ENTRYPOINT ["java", "-jar","/app.jar"]