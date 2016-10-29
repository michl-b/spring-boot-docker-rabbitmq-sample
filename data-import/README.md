# data-importer

I am a Spring Boot Service which connects to a RabbitMQ queue and send itself a message via queue called "spring-boot"

## tech

- Spring Boot
  - DevTools
  - Actuator
  - Docker Plugin
- Maven
- H2 DB
- RabbitMQ

## build docker image
```bash
mvn package docker:build -DpushImage=false
```
