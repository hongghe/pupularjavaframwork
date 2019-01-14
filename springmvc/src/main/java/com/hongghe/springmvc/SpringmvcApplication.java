package com.hongghe.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringmvcApplication {

    static {

    }

    @Bean
    public SpringmvcInitializer springmvcInitializer() {
        return new SpringmvcInitializer();
    }

    @Bean
    public SpringmvcProperties springmvcProperties() {
        return new SpringmvcProperties();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);
    }

}

