package com.hongghe.dubboconsumer.message;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-12 16:25
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class GreetingResponse {
    private final String responseMessage;
}
