# Use a base image with Java 11
FROM openjdk:11
 
# Copy the JAR package into the image
ARG JAR_FILE=./*.jar
COPY ${JAR_FILE} app.jar
 
# Expose the application port
EXPOSE 9876
 
# Run the App
ENTRYPOINT ["java", "-jar", "/app.jar"]