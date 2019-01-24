package com.hongghe.kafka.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author: hongghe @date: 2019-01-24 19:31
 */
@Data
@ToString
public class Result<T> {
    public int code;
    public String msg;
    public T data;
}
