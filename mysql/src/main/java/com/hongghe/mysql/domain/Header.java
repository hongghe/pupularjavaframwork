package com.hongghe.mysql.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author hongghe 2018/12/29
 */
@Data
@Builder(builderClassName = "Builder", toBuilder = true)
public class Header {

    /**
     * user uid
     */
    private final Long uid;

    /**
     * The user client ip address
     */
    private final String clientIp;
}
