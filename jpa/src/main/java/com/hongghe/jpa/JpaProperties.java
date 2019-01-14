package com.hongghe.jpa;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-05 11:04
 */
@Component
@PropertySource("classpath:application-default.properties")
@ConfigurationProperties(prefix = "jdademo")
public class JpaProperties {
}
