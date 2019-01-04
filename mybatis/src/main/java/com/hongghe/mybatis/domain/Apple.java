package com.hongghe.mybatis.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author hongghe 2019/1/4
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class Apple {
    private String address;
}
