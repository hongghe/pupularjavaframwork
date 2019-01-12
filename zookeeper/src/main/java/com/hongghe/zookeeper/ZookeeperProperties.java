package com.hongghe.zookeeper;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: hongghe @date: 2019-01-12 14:40
 */
@Data
@ConfigurationProperties(prefix = "zookeeperdemo")
public class ZookeeperProperties {
}
