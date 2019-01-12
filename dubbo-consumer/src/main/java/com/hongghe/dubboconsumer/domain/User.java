package com.hongghe.dubboconsumer.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-12 16:24
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class User {
    private final String name;
    private final Integer age;
}
