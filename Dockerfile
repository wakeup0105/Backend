FROM openjdk:21-jdk-slim
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} wakeup-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/wakeup-0.0.1-SNAPSHOT.jar"]