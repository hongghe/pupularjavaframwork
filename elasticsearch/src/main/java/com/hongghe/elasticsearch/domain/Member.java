package com.hongghe.elasticsearch.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-11 18:02
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class Member {
    private final String name;
    private final Integer age;
    private final String address;
}
