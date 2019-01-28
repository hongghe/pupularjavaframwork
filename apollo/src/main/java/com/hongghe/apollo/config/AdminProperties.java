package com.hongghe.apollo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-28 15:54
 */
@Data
@Component
@ConfigurationProperties(prefix = "adminproperties")
public class AdminProperties {
    private String name;
    private int age;
}
