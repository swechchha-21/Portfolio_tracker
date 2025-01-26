# 1. Use an official Java runtime image as the base image
FROM openjdk:17-jdk-slim

# 2. Set the working directory inside the container
WORKDIR /app

# 3. Copy the JAR file from the local system into the container
COPY target/assignmentProject-0.0.1-SNAPSHOT.jar app.jar

# 4. Expose the port your Spring Boot application runs on (default: 8080)
EXPOSE 8080

# 5. Define the command to run your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
