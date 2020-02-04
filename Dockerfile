FROM openjdk:8
ADD target/boulder-bucket-list-0.0.1-SNAPSHOT.jar boulder-bucket-list-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","boulder-bucket-list-0.0.1-SNAPSHOT.jar"]
