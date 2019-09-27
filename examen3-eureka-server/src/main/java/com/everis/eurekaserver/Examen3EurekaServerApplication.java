package com.everis.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Examen3EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Examen3EurekaServerApplication.class, args);
	}

}
