FROM openjdk:8-jdk-alpine
VOLUME /tmp
ENV JAR_FILE="build/libs/*.jar"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]