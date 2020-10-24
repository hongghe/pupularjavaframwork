package com.hongghe.aop.domain;

import lombok.Data;

/**
 * @author: hongghe @date: 2019-02-19 09:50
 */
@Data
public class Result<T> {
    private int ret;
    private String message;
    private T data;

    Result() {
    }
}
