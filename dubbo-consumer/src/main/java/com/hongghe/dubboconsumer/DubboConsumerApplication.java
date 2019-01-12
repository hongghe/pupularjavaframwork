package com.hongghe.dubboconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@EnableConfigurationProperties
@SpringBootApplication
public class DubboConsumerApplication {

	@Bean
	public DubboConsumerInitializer dubboConsumerInitializer() {
		return new DubboConsumerInitializer();
	}

	@Bean
	public DubboConsumerProperties dubboConsumerProperties() {
		return new DubboConsumerProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class, args);
	}

}

