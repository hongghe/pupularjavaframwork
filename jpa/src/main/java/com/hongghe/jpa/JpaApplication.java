package com.hongghe.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync
@EnableSwagger2
@ServletComponentScan
@SpringBootApplication
public class JpaApplication {

	@Bean
	public JpaInitializer jpaInitializer() {
		return new JpaInitializer();
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}

