package com.hongghe.redis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: hongghe @date: 2019-03-18 18:17
 */
public abstract class RedisLock implements Lock {

    @Autowired
    protected RedisTemplate<String,String> redisTemplate;

    protected String lockKey;

    public RedisLock(RedisTemplate redisTemplate, String lockKey) {
        this.lockKey = lockKey;
        this.redisTemplate = redisTemplate;
    }


    public void sleepBySencond(int sencond){
        try {
            Thread.sleep(sencond*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void lockInterruptibly(){}

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit){
        return false;
    }
}
