package com.hongghe.redis.component;

/**
 * @author: hongghe @date: 2019-03-18 18:05
 */
public class LockConstants {
    /** the lock success */
    public static final String OK = "OK";
    /** NX|XX, NX -- Only set the key if it does not already exist. XX -- Only set the key if it already exist. **/
    public static final String NOT_EXIST = "NX";
    public static final String EXIST = "XX";
    /** expx EX|PX, expire time units: EX = seconds; PX = milliseconds **/
    public static final String SECONDS = "EX";
    public static final String MILLISECONDS = "PX";
}
