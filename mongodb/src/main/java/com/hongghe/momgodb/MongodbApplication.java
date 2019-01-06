package com.hongghe.momgodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 */
@SpringBootApplication
@EnableConfigurationProperties
public class MongodbApplication {

	@Bean
	public MongodbInitializer mongodbInitializer() {
		return new MongodbInitializer();
	}

	@Bean
	public MongodbProperties mongodbProperties() {
		return new MongodbProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

}

