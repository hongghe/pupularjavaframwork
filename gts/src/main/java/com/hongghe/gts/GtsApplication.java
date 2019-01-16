package com.hongghe.gts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GtsApplication {

    @Bean
    public GtsInitializer gtsInitializer() {
        return new GtsInitializer();
    }

    public static void main(String[] args) {
        SpringApplication.run(GtsApplication.class, args);
    }

}

