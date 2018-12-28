package com.hongghe.redis.domain;

import lombok.Data;

/**
 * @author hongghe 2018/12/28
 */
@Data
public class Header {

    /**
     * The uid of user
     */
    private final Long uid;

    /**
     * The client ip of user
     */
    private final String clientIp;

}
