package com.hongghe.rabbitmq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hongghe 2018/12/29
 */
@Data
@ConfigurationProperties(prefix = "rabbitmqdemo")
public class RabbitmqProperties {
}
