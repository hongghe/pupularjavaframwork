package com.hongghe.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MybatisApplication {

	@Bean
	public MybatisInitializer mybatisInitializer() {
		return new MybatisInitializer();
	}

	@Bean
	public MybatisProperties mybatisProperties() {
		return new MybatisProperties();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(MybatisApplication.class, args);
	}

}

