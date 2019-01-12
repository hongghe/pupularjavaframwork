package com.hongghe.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApolloApplication {

	@Bean
	public ApolloProperties apolloProperties() {
		return new ApolloProperties();
	}

	@Bean
	public ApolloInitializer apolloInitializer() {
		return new ApolloInitializer();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApolloApplication.class, args);
	}

}

