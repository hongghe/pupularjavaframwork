package com.hongghe.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudAlibabaApplication {

	@Bean
	public SpringCloudAlibabaInitializer springCloudAlibabaInitializer() {
		return new SpringCloudAlibabaInitializer();
	}

	@Bean
	public SpringCloudAlibabaProperties springCloudAlibabaProperties() {
		return new SpringCloudAlibabaProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAlibabaApplication.class, args);
	}

}

