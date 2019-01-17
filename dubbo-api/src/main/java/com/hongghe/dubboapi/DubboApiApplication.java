package com.hongghe.dubboapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class DubboApiApplication {

	@Bean
	public DubboApiInitializer dubboApiInitializer() {
		return new DubboApiInitializer();
	}

	@Bean
	public DubboApiProperties dubboApiProperties() {
		return new DubboApiProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(DubboApiApplication.class, args);
	}

}

