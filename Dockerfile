# Use Eclipse Temurin Java 17 as base image (modern replacement for OpenJDK)
FROM eclipse-temurin:17-jre-jammy

# Set working directory
WORKDIR /app

# Copy the WAR file
COPY target/employee-transfers-0.0.1.war app.war

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.war"]
