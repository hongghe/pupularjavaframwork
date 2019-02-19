package com.hongghe.aop.domain;

/**
 * @author: hongghe @date: 2019-02-19 09:50
 */
public class Result<T> {
    private int ret;
    private String message;
    private T data;

    Result() {
    }
}
