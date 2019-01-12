package com.hongghe.apollo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-12 16:31
 */
@Data
@Component
@ConfigurationProperties(prefix = "apollodemo")
public class ApolloProperties {
}
