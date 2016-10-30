# data-care

I am a Spring Boot Service which allows you to send messages via RabbitMQ.

You can send messages at /message view.

## tech

- Java 8
- Kotlin
- Spring Boot
  - DevTools
  - Actuator
  - Docker Plugin
- Maven
- Thymeleaf
- Bootstrap 4 alpha
- RabbitMQ
- Eureka Service Discovery

## build docker image
```bash
mvn package docker:build -DpushImage=false
```
