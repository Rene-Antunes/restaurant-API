package com.restaurante.plataform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestauranteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestauranteApiApplication.class, args);
	}

}
