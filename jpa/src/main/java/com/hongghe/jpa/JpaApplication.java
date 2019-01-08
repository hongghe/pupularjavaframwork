package com.hongghe.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan
@SpringBootApplication
public class JpaApplication {

	@Bean
	public JpaInitializer jpaInitializer() {
		return new JpaInitializer();
	}

	@Bean
	public JpaProperties jpaProperties() {
		return new JpaProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}

