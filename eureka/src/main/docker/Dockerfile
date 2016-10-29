FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp
ADD eureka.jar app.jar

EXPOSE 8761

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java", "-Dserver.port=8761", "-jar", "/app.jar"]