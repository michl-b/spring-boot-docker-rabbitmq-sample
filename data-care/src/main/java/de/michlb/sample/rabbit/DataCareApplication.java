package de.michlb.sample.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaClient
public class DataCareApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(DataCareApplication.class);

    @Value("${info.app.version}")
    private String appVersion = null;

    @Value("${info.app.name}")
    private String appName = null;

    public static void main(String[] args) {
        SpringApplication.run(DataCareApplication.class, args);
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
