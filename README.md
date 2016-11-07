# spring-boot-docker-rabbitmq-sample

- RabbitMQ
- Spring Boot Apps
- Spring Cloud - Eureka
- Spring Boot Admin by codecentric
- Docker compose

![System Image](docs/spring-bootdockerrabbitmq.png)


## RabbitMQ
for Management Console

default user: guest

default password: guest

## build 
```bash
mvn clean install
```
in this step, also the docker images will be created (see docker-maven-plugin)

## run with docker-compose
run...
```bash
docker-compose up -d
```
stop!
```bash
docker-compose stop
```
cleanup
```bash
docker-compose rm
```
check
```bash
docker-compose ps
```
