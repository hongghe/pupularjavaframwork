package com.hongghe.springbootweb.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-07 20:57
 */
@Component
public class RedisToolComponent {

    @Autowired
    private RedisTemplate redisTemplate;
}
