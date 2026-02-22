FROM maven:3.9.9-amazoncorretto-17 AS builder

WORKDIR /app

COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

