package com.hongghe.redis.component;

import com.hongghe.redis.RedisApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author: hongghe @date: 2019-01-05 11:16
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RedisApplication.class})
@TestPropertySource("classpath:application-default.yml")
public class RedisComponentTest {

    @Autowired
    private RedisComponent redisComponent;

    @Test
    public void getRedisValue() {
        redisComponent.getRedisValue("key");
    }
}