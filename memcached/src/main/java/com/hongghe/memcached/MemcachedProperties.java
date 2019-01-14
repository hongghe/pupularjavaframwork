package com.hongghe.memcached;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author hongghe 2018/12/28
 */
@Component
@PropertySource(("classpath:application-default.yml"))
@ConfigurationProperties(prefix = "memcacheddemo")
public class MemcachedProperties {
}
