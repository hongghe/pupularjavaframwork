package com.hongghe.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author henry
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {

    @Bean
    public AopInitializer aopInitializer() {
        return new AopInitializer();
    }

    @Bean
    public AopProperties aopProperties() {
        return new AopProperties();
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

}

