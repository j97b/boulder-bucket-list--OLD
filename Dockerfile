FROM openjdk:8
ADD target/boulder-bucket-list.jar boulder-bucket-list.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","boulder-bucket-list.jar"]
