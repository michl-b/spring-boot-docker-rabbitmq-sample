package de.michlb.sampe.rabbit;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class SpringBootAdminApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(SpringBootAdminApplication.class);

    @Value("${info.app.version}")
    private String appVersion = null;

    @Value("${info.app.name}")
    private String appName = null;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApplication.class, args);
    }

    @PostConstruct
    public void writeInfos() {
        LOGGER.info("############################################");
        LOGGER.info("            STARTUP");
        LOGGER.info("############################################");
        LOGGER.info("Application Name: " + appName);
        LOGGER.info("Application Version: " + appVersion);
    }
}
