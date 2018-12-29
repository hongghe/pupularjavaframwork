package com.hongghe.grpcserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The startup class of project.
 *
 * @author hongghe
 */
@SpringBootApplication
public class GrpcServerApplication {

	@Bean
	public GrpcServerInitializer grpcServerInitializer() {
		return new GrpcServerInitializer();
	}

	@Bean
	public GrpcServerProperties grpcServerProperties() {
		return new GrpcServerProperties();
	}

	public static void main(String[] args) {
		SpringApplication.run(GrpcServerApplication.class, args);
	}

}

