package com.hongghe.springmvc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-13 17:46
 */
@Component
@PropertySource(value = "classpath:/application-default.properties")
@ConfigurationProperties(prefix = "springmvcdemo")
public class SpringmvcProperties {
}
