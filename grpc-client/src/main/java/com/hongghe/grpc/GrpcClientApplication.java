package com.hongghe.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The start up class.
 *
 * @author hongghe
 */
@SpringBootApplication
public class GrpcClientApplication {

	@Bean
	public GrpcClientProperties grpcClientProperties() {
		return new GrpcClientProperties();
	}

	@Bean
	public GrpcClientInitializer grpcClientInitializer() {
		return new GrpcClientInitializer();
	}

	public static void main(String[] args) {
		SpringApplication.run(GrpcClientApplication.class, args);
	}

}

