FROM openjdk:8-jdk-alpine
ADD target/spring-reactive-crud-repository-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]