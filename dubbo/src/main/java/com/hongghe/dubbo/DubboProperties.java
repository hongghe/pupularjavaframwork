package com.hongghe.dubbo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hongghe 2018/12/29
 */
@Data
@ConfigurationProperties(prefix = "dubbodemo")
public class DubboProperties {
}
