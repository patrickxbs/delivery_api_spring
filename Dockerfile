FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app

COPY . .
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

