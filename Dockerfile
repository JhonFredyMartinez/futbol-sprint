# Etapa 1: Build (Compilar el JAR)
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Runtime (Ejecutar el JAR)
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/futbol-1.jar app.jar
EXPOSE 8096
ENTRYPOINT ["java", "-jar", "app.jar"]
