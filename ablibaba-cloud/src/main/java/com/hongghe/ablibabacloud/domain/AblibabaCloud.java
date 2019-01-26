package com.hongghe.ablibabacloud.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author: hongghe @date: 2019-01-19 15:00
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class AblibabaCloud {

    /**Name of alibaba cloud. */
    private String name;
}
