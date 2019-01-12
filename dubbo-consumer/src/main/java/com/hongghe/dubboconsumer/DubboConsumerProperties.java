package com.hongghe.dubboconsumer;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: hongghe @date: 2019-01-05 12:25
 */
@Data
@ConfigurationProperties(prefix = "dubboconsumerdemo")
public class DubboConsumerProperties {
}
