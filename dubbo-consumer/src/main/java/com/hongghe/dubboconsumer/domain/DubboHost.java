package com.hongghe.dubboconsumer.domain;

import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-12 16:28
 */
@Data
public class DubboHost {
    private String address;
    private Integer port;
}
