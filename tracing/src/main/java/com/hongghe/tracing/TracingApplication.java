package com.hongghe.tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * start up class of project.
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class TracingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracingApplication.class, args);
    }

}

