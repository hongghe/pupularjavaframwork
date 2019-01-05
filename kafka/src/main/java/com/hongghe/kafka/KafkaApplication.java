package com.hongghe.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaApplication {

	@Bean
	public KafkaInitalizer kafkaInitalizer() {
		return new KafkaInitalizer();
	}

	@Bean
	public KafkaProperties kafkaProperties() {
		return new KafkaProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}

