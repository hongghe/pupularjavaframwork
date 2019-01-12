package com.hongghe.apollo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: hongghe @date: 2019-01-12 16:31
 */
@Data
@ConfigurationProperties(prefix = "apollodemo")
public class ApolloProperties {
}
