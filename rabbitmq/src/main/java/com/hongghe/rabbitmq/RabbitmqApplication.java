package com.hongghe.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *  启动类
 *
 *  @author hongghe
 */
@EnableRabbit
@SpringBootApplication
public class RabbitmqApplication {

	@Bean
	public RabbitmqInitializer rabbitmqInitializer() {
		return new RabbitmqInitializer();
	}

	@Bean
	public RabbitmqProperties rabbitmqProperties() {
		return new RabbitmqProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

}

