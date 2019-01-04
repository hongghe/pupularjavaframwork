package com.hongghe.mybatis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hongghe 2019/1/4
 */
@Data
@ConfigurationProperties(prefix = "mybatisdemo")
public class MybatisProperties {
}
