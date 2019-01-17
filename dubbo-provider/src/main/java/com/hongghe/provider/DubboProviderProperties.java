package com.hongghe.provider;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: hongghe @date: 2019-01-05 15:42
 */
@Data
@ConfigurationProperties(prefix = "dubboproviderdemo")
public class DubboProviderProperties {
}
