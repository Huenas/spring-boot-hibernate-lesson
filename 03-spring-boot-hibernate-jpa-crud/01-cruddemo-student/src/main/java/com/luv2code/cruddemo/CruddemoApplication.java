package com.luv2code.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//je veux run cette classe mais ça marche pas
	//j'ai créé le projet avec spring initializr, j'ai juste rajouter le code en dessous
	// et dans udemy lui il run ça oklm juste après avoir ajotué lles 5 lignes

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {

		return runner -> {
			System.out.println("hello world");
		}
	}
}
