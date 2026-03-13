FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/miguel-0.0.1.jar
COPY ${JAR_FILE} miguelAPI.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "miguelAPI.jar"]