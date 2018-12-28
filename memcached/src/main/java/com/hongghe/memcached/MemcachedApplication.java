package com.hongghe.memcached;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 */
@SpringBootApplication
public class MemcachedApplication {

	@Bean
	public MemcachedInitializer memcachedInitializer() {
		return new MemcachedInitializer();
	}

	@Bean
	public MemcachedProperties memcachedProperties() {
		return new MemcachedProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(MemcachedApplication.class, args);
	}

}

