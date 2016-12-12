FROM openjdk:8-jre-alpine

MAINTAINER rgrebski@gmail.com

VOLUME /tmp
ADD grails-linkedin-integration-0.1.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]