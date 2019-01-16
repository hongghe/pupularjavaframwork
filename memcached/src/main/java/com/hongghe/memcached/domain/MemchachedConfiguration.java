package com.hongghe.memcached.domain;

import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-14 20:49
 */
@Data
public class MemchachedConfiguration {
    private String ip;
    private Integer port;
}
