package com.hongghe.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class CassandraApplication {

    @Bean
    public CassandraInitializer cassandraInitializer() {
        return new CassandraInitializer();
    }

    @Bean
    public CassandraWebConfig cassandraWebConfig() {
        return new CassandraWebConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(CassandraApplication.class, args);
    }

}

