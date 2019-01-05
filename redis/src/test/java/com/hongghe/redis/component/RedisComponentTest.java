package com.hongghe.redis.component;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: hongghe @date: 2019-01-05 11:16
 */
public class RedisComponentTest {

    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void getRedisValue() {
        redisComponent.getRedisValue("key");
    }
}