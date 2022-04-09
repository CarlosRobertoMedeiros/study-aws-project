FROM amazoncorretto:11-alpine-jdk
VOLUME /tmp
MAINTAINER carlosmedeiroslima@gmail.com
EXPOSE 8080
COPY target/aws_project01-0.0.1-SNAPSHOT.jar aws_project01-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/aws_project01-0.0.1-SNAPSHOT.jar"]