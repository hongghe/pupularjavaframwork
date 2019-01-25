package com.hongghe.cassandra;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: hongghe @date: 2019-01-25 11:37
 */
@Data
@ConfigurationProperties(prefix = "cassandrademo")
public class CassandraProperties {
}
