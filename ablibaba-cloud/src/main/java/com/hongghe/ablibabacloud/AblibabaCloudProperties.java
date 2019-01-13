package com.hongghe.ablibabacloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-13 13:23
 */
@Component
@PropertySource(value = "classpath:/application.properties")
@ConfigurationProperties(prefix = "alibabaclouddemo")
public class AblibabaCloudProperties {
}
