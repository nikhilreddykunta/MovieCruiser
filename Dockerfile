FROM openjdk:10-jre

ADD ./target/moviedb-0.0.1-SNAPSHOT.jar /usr/app/moviedb-0.0.1-SNAPSHOT.jar

WORKDIR usr/app

ENTRYPOINT ["java","-jar", "moviedb-0.0.1-SNAPSHOT.jar"]