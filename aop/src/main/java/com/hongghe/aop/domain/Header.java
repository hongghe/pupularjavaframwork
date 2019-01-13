package com.hongghe.aop.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-13 14:43
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class Header {
    private final String uid;
    private final Long channelId;
    private final String userAgent;
    private final String ua;
}
