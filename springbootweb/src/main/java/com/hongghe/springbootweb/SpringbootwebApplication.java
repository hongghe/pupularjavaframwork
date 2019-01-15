package com.hongghe.springbootweb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

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

	@Bean
	@Qualifier("string_redis")
	public RedisTemplate<String, String> redisTemplate() {
		RedisTemplate redisTemplate = new RedisTemplate();
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);
	}

}

