#FROM ubuntu:latest
#LABEL authors="PC"

#ENTRYPOINT ["top", "-b"]

# Use a lightweight Java image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/assignment-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
