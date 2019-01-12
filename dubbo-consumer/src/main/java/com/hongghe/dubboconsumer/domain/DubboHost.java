package com.hongghe.dubboconsumer.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-12 16:28
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class DubboHost {
    private final String address;
    private final Integer port;
}
