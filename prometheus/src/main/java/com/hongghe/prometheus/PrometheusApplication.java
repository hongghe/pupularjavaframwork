package com.hongghe.prometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class PrometheusApplication {

    @Bean
    public PrometheusInitializer prometheusInitializer() {
        return new PrometheusInitializer();
    }

    @Bean
    public PrometheusProperties prometheusProperties() {
        return new PrometheusProperties();
    }

    public static void main(String[] args) {
        SpringApplication.run(PrometheusApplication.class, args);
    }

}

