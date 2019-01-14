package com.hongghe.memcached;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 */
@Slf4j
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties
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

