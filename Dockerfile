FROM maven AS build
COPY . /home/maven/project
WORKDIR /home/maven/project
RUN mvn clean install
RUN mvn test

FROM openjdk:8-jre-slim

EXPOSE 8090

RUN mkdir /app

COPY --from=build /home/maven/project/target/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]
