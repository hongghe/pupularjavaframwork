package com.hongghe.apollo.domain;

/**
 * @author: hongghe @date: 2019-01-12 16:46
 */
public enum UserType {

    STUDENT(1),
    TEACHER(2),
    ADMIN(3),
    ;

    private int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
