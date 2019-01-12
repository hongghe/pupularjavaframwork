package com.hongghe.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NacosApplication {

    @Bean
    public NacosInitializer nacosInitializer() {
        return new NacosInitializer();
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }

}

