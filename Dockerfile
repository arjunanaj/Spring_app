FROM openjdk:17
WORKDIR /app
EXPOSE 9091
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar","app.jar"]