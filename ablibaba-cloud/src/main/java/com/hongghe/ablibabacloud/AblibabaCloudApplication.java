package com.hongghe.ablibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AblibabaCloudApplication {

    @Bean
    public AblibabaCloudInitializer ablibabaCloudInitializer() {
        return new AblibabaCloudInitializer();
    }

    @Bean
    public AblibabaCloudProperties ablibabaCloudProperties() {
        return new AblibabaCloudProperties();
    }

    public static void main(String[] args) {
        SpringApplication.run(AblibabaCloudApplication.class, args);
    }

}

