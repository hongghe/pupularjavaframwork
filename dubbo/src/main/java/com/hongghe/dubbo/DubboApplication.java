package com.hongghe.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author hongghe
 */
@SpringBootApplication
public class DubboApplication {

	@Bean
	public DubboInitializer dubbotInitializer() {
		return new DubboInitializer();
	}

	@Bean
	public DubboProperties dubbotProperties() {
		return new DubboProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(DubboApplication.class, args);
	}

}

