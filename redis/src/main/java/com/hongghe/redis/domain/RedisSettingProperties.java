package com.hongghe.redis.domain;

import lombok.Data;

/**
 * @author hongghe 2018/12/28
 */
@Data
public class RedisSettingProperties {

    /**
     * The redis host
     */
    private String host;

    /**
     * The port of redis server
     */
    private Integer port;

    /**
     * The password of redis
     */
    private String password;

}
