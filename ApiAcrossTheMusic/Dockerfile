FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/ApiAcrossMusic-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} api_across_the_music.jar
EXPOSE 8099
ENTRYPOINT ["java","-jar","api_across_the_music.jar"]