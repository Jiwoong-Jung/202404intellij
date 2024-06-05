FROM openjdk:11
VOLUME /tmp
ADD target/application-0.0.1-SNAPSHOT.jar springboot-docker-compose.jar
EXPOSE 4321
ENTRYPOINT ["java","-jar","springboot-docker-compose.jar"]