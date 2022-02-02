FROM openjdk:11
EXPOSE: 8080
ADD target/spring-boot-actions-ci.jar spring-boot-actions-ci.jar
ENTRYPOINT ["java", "-jar", "/pring-boot-actions-ci.jar"]