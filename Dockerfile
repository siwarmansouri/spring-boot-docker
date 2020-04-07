# Start with a base image containing Java runtime ( FROM openjdk:8-jdk-alpine or FROM scratch)
FROM java:8-jdk-alpine

# Add the application's jar to the container
WORKDIR /usr/app
COPY ./build/libs/gs-spring-boot-0.1.0.jar /usr/app/

# Run the jar file
RUN sh -c 'touch gs-spring-boot-0.1.0.jar'

ENTRYPOINT ["java","-jar","gs-spring-boot-0.1.0.jar"]