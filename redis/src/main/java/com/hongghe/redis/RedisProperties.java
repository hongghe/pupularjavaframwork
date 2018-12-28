package com.hongghe.redis;

import com.hongghe.redis.domain.RedisSettingProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hongghe 2018/12/25
 */
@Data
@ConfigurationProperties(prefix = "redisdemo")
public class RedisProperties {

    private final RedisSettingProperties redisSettingProperties = new RedisSettingProperties();
}
