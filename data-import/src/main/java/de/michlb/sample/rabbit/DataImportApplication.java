package de.michlb.sample.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DataImportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataImportApplication.class, args);
	}
}
