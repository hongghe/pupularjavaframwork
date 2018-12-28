package com.hongghe.momgodb;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hongghe 2018/12/28
 */
@Data
@ConfigurationProperties(prefix = "mongodbdemo")
public class MongodbProperties {
}
