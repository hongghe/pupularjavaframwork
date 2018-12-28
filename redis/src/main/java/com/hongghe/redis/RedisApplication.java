package com.hongghe.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author hongghe
 */
@SpringBootApplication
@EnableScheduling
public class RedisApplication {

	@Bean
	public RedisInitializer redisInitializer() {
		return new RedisInitializer();
	}

	@Bean
	public RedisProperties redisProperties() {
		return new RedisProperties();
	}


	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}

