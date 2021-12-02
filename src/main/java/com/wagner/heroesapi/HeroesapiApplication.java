package com.wagner.heroesapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// A anotação abaixo serve para configurar a documentação do Swagger
@OpenAPIDefinition(info = @Info(
		title = "HERO API",
		version = "1.0",
		description = "Gerenciador de super heróis da Marvel e da DC em uma API reativa com Spring Boot",
		contact = @Contact(name = "Wagner Kaba", url = "https://github.com/wagnerkaba", email = "elguapore@gmail.com")))
@EnableDynamoDBRepositories
public class HeroesapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(HeroesapiApplication.class, args);

		System.out.println("super poderes com webflux");


	}

}
