package com.hongghe.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: hongghe @date: 2019-01-14 20:30
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        return redisTemplate;
    }
}
