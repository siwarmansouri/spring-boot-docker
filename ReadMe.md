## Create a simple web application using Spring Boot and Gradle ##

### Spring boot debug mode ###
./gradlew bootRun --debug-jvm  + Remote JVM debug mode

### Spring boot run app ###
./gradlew build && java -jar build/libs/gs-spring-boot-0.1.0.jar 


### Test endpoints with Curl ###
./gradlew build && java -jar build/libs/gs-spring-boot-0.1.0.jar 

$GET
curl -v localhost:8080/products

$POST
curl -d '{"id":"3","name":"Sugar"}' -H "Content-Type: application/json" localhost:8080/products

$PUT
curl -d '{"id":"3","name":"SugarExtra"}' -H "Content-Type: application/json" -X PUT localhost:8080/products/3

$DELETE
curl -X DELETE localhost:8080/products/3

### Run this application in a docker container using Dockerfile ###
./gradlew build 

docker build -t spring-boot-docker .

docker images

docker run -p 8090:8080 spring-boot-docker   (host operating system port: 8090 && port inside the container: 8080)

