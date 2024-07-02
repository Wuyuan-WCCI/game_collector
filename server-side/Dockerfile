FROM ubuntu:latest as build
RUN apt-get update 
RUN apt-get install openjdk:17-jdk -y
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk:17-jdk-slim

EXPOSE 8080
# Copy the JAR file into the container
COPY build/libs/server-side-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available to the world outside this container


COPY --from=build build/libs/server-side-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
