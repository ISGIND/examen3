package com.everis.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class Examen3ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Examen3ConfigServerApplication.class, args);
	}

}
