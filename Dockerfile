FROM eclipse-temurin:17-jre
WORKDIR /app
COPY build/libs/BooksApp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 10003
ENTRYPOINT ["java", "-jar", "app.jar"]