package com.hongghe.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootwebApplication {

	@Bean
	public SpringbootwebProperties springbootwebProperties() {
		return new SpringbootwebProperties();
	}

	@Bean
	public SpringbotwebInitializer springbotwebInitializer() {
		return new SpringbotwebInitializer();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);
	}

}

