package com.hongghe.dubboconsumer.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-12 16:29
 */
@Component
public class RedisComponent {

    @Autowired
    private RedisTemplate redisTemplate;

    public String updateRedis(String key, String value) {
        return null;
    }
}
