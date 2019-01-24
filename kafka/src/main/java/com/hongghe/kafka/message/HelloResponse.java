package com.hongghe.kafka.message;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-24 19:37
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class HelloResponse {

    @lombok.Builder.Default
    private String greeting = "hello,man!";
}
