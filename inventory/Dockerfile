FROM amazoncorretto:17-alpine
RUN mkdir /app
COPY app.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
