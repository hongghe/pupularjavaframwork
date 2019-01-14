package com.hongghe.prometheus;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-14 16:02
 */
@Component
@ConfigurationProperties(prefix = "prometheusdemo")
public class PrometheusProperties {
}
