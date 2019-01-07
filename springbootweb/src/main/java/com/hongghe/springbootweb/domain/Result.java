package com.hongghe.springbootweb.domain;

import java.util.HashMap;

/**
 * @author: hongghe @date: 2019-01-07 21:00
 */
public class Result {

    /**
     * The return code of API.
     */
    public Integer code;

    /**
     * The message from description of API.
     */
    public String message;

    /**
     * The data domain.
     */
    public Object data = new HashMap<>();

    Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
