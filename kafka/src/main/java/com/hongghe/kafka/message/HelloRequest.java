package com.hongghe.kafka.message;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-24 19:36
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class HelloRequest {

    @lombok.Builder.Default
    private String message = "hello";
}
