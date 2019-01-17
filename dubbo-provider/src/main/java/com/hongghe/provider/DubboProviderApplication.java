package com.hongghe.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableAsync
@CrossOrigin
@EnableScheduling
@SpringBootApplication
public class DubboProviderApplication {

	@Bean
	public DubboProviderInitializer dubboProviderInitializer() {
		return new DubboProviderInitializer();
	}

	@Bean
	public DubboProviderProperties dubboProviderProperties() {
		return new DubboProviderProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderApplication.class, args);
	}

}

