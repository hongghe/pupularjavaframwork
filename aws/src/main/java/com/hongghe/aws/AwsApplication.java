package com.hongghe.aws;

import com.hongghe.aws.configuration.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class AwsApplication {

    @Bean
    public AwsInitializer awsInitializer() {
        return new AwsInitializer();
    }

    @Bean
    @ConfigurationProperties(prefix = "awsdemo.person")
    public Person person() {
        return new Person();
    }

    public static void main(String[] args) {
        SpringApplication.run(AwsApplication.class, args);
    }

}

