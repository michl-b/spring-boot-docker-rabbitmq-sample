# data-backend

I am a Spring Boot Service which connects to a RabbitMQ queue and send itself a message via queue called "spring-boot"

You can display all received messages at /messages view.

## tech

- Java 8
- Kotlin
- Spring Boot
  - DevTools
  - Actuator
  - Docker Plugin
- Maven
- H2 DB
- Thymeleaf
- Bootstrap 4 alpha
- RabbitMQ
- Eureka Service Discovery

## build docker image
```bash
mvn package docker:build -DpushImage=false
```
