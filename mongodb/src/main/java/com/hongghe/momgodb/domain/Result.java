package com.hongghe.momgodb.domain;

import lombok.Data;

import java.util.HashMap;

/**
 * @author hongghe 2018/12/28
 */
@Data
public class Result {

    /**
     * 错误码
     */
    public int code;

    /**
     * 错误码对应信息
     */
    public String message;

    public Object data = new HashMap<>();

}
