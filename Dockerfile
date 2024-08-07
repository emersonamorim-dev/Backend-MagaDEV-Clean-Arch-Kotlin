# Use a imagem base do Maven para construir o projeto
FROM maven:3.8.4-openjdk-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a imagem base do OpenJDK para rodar a aplicação
FROM openjdk:21-jdk
WORKDIR /app
COPY --from=build /app/target/your-application-jar-file.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
