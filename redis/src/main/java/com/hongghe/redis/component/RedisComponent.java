package com.hongghe.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-05 11:13
 */
@Component
public class RedisComponent {

    @Autowired
    private RedisTemplate redisTemplate;

    public void getRedisValue(String key) {
        if (redisTemplate.hasKey(key)) {
            System.out.println("The redis");
        }
        System.out.println("Not redis ");
    }


}
