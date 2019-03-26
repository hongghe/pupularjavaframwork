package com.hongghe.redis.component.redis.lock;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-03-21 16:59
 */
@Component
public class LuaRedisLockComponent<K, V> {

    static {
        String LUA_LOCK = "";
    }

    private RedisTemplate<K, V> redisTemplate;

    public boolean requireLock(K key, V value) {
        if (redisTemplate.opsForValue().get(key) != null) {
            return true;
        }

        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    public boolean releaseLock() {
        return true;
    }
}
