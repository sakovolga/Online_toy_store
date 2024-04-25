FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/Online_toy_store.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]