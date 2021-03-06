package com.hongghe.redis.component.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: hongghe @date: 2019-03-20 10:21
 */
@Component
public class RedisLockComponent {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    RedisLockComponent(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public static boolean lock(StringRedisTemplate stringRedisTemplate, TimeUnit timeUnit, Object object) {
        if (null == stringRedisTemplate) {
            return false;
        }

        stringRedisTemplate.hasKey((String)object);
        stringRedisTemplate.opsForValue().set((String) object, "OK", 1000L, timeUnit);
        return false;
    }

    public static boolean synLock(Object object, StringRedisTemplate stringRedisTemplate) {
        return false;
    }
}
