package com.hongghe.zookeeper.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-14 20:58
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class ZookeeperProperties {
    private final String addressUrl;
    private final Integer port;
}
