package com.hongghe.redis.component;

import com.google.common.hash.Hashing;
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

    /**
     * MD5的32位的HASH值
     * @param key 唯一的KEY
     * @param value 存储的内容信息
     * @return 是否存储成功
     */
    public boolean setMD5And32BitKey(String key, String value) {
        String keyHash = Hashing.md5().hashBytes(key.getBytes()).toString();
        return true;
    }

    /**
     * MD5的64位的HASH值
     * @param key 唯一的KEY
     * @param value 存储的内容信息
     * @return 是否存储成功
     */
    public boolean setMd5And64BitKey(String key, String value) {
        String keyHash = Hashing.md5().hashBytes(key.getBytes()).toString();
        return true;
    }

    public boolean setSHA256Key(String key, String value) {
        String keyHash = Hashing.sha1().hashBytes(key.getBytes()).toString();
        return true;
    }

    public boolean setSHA512Key(String key, String value) {
        String keyHash = Hashing.sha512().hashBytes(key.getBytes()).toString();
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Hashing.md5().hashBytes(("zhan").getBytes()).toString());
    }
}
