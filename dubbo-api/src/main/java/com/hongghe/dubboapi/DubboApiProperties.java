package com.hongghe.dubboapi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: hongghe @date: 2019-01-05 12:23
 */
@Data
@ConfigurationProperties(prefix = "dubboapidemo")
public class DubboApiProperties {
}
