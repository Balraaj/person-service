FROM openjdk:11
ADD target/reacted-0.0.1-SNAPSHOT.jar reacted-0.0.1-SNAPSHOT.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "reacted-0.0.1-SNAPSHOT.jar"]