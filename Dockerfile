FROM openjdk:17
EXPOSE 8989
ADD target/api-gateway-service.jar api-gateway-service.jar
ENTRYPOINT ["java","-jar","/api-gateway-service.jar"]