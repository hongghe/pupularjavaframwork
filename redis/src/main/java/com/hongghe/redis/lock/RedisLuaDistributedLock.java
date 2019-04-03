package com.hongghe.redis.lock;

import redis.clients.jedis.Jedis;

/**
 * @author: hongghe @date: 2019-04-03 09:56
 */
public class RedisLuaDistributedLock {

    /** 锁设置 */
    private static final Long lockReleaseOk = 1L;
    /** 脚本设置 */
    private static String LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";

    public static boolean releaseLock(String key, String value) {
        if (key == null || value == null) {
            return false;
        }

        try {
            Jedis jedis = new Jedis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
