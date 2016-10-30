FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp
ADD spring-boot-admin.jar app.jar

EXPOSE 8080

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "/app.jar"]