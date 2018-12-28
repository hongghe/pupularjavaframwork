package com.hongghe.memcached;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hongghe 2018/12/28
 */
@Data
@ConfigurationProperties(prefix = "memcacheddemo")
public class MemcachedProperties {
}
