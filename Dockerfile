# Base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR .

# Copy files
COPY . .

EXPOSE 80

# Run the application
CMD ["java", "-jar", "sajuoct.jar"]