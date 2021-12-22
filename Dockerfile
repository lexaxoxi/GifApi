FROM adoptopenjdk/openjdk11:latest
LABEL maintrainer = "Alexey"
COPY build/libs/*.jar /app.jar
EXPOSE 5600
ENTRYPOINT ["java","-jar","/app.jar"]
