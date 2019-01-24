package com.hongghe.kafka.domain;

/**
 * @author: hongghe @date: 2019-01-24 19:31
 */
public enum ResultConst {

    ERROR(-1, "error"),
    SUCCUSS(0,"success"),
    ;

    private int code;
    private String msg;

    ResultConst(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
