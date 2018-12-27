package com.hongghe.grpc.domain;

/**
 * @author hongghe 2018/12/25
 */
public enum UserType {

    /**
     * personal
     */
    PERSON_TYPE(1),

    /**
     * company type
     */
    COMPANY_TYPE(2),
    ;

    private Integer type;

    UserType(Integer type) {
        this.type = type;
    }

}
