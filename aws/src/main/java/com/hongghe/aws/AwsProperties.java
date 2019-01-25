package com.hongghe.aws;

import com.hongghe.aws.configuration.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-25 14:23
 */
@Component
@ConfigurationProperties(prefix = "awsdemo")
public class AwsProperties {
    private Person person = new Person();
}
