package com.hongghe.dubbo.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author hongghe 2018/12/24
 */
@Component
@ConfigurationProperties(prefix = "com.hongghe")
@PropertySource(value = "application.properties")
public class PropertiesConfig {
}
