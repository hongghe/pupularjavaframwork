package com.hongghe.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZookeeperApplication {

    @Bean
    public ZookeeperInitializer zookeeperInitializer() {
        return new ZookeeperInitializer();
    }

    @Bean
    public ZookeeperProperties zookeeperProperties() {
        return new ZookeeperProperties();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperApplication.class, args);
    }

}

