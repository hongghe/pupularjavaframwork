package com.hongghe.mysql;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hongghe 2018/12/28
 */
@Data
@ConfigurationProperties(value = "mysqldemo")
public class MysqlProperties {
}
