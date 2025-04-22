# Start with a lightweight Java image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/my-app.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
