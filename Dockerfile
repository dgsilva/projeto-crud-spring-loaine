FROM openjdk:17-jdk-slim
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/crud-spring-1.0.0-SNAPSHOT.jar
EXPOSE 8082
WORKDIR /app
ENTRYPOINT java -jar crud-spring-1.0.0-SNAPSHOT.jar