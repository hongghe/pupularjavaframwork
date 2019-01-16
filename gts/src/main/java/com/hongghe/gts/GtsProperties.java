package com.hongghe.gts;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: hongghe @date: 2019-01-15 20:21
 */
@Data
@ConfigurationProperties(prefix = "gtsdemo")
public class GtsProperties {
}
