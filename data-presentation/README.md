# data-presentation

I am a Spring Boot Service displays data received via REST from a data backend service

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
- Eureka Service Discovery

## build docker image
```bash
mvn package docker:build -DpushImage=false
```
