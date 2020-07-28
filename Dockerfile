FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/educom-0.0.1-SNAPSHOT.jar educombackend.jar
ENTRYPOINT ["java","-jar","educombackend.jar"]