package com.hongghe.redis.domain;

/**
 * 接口返回状态码和提示信息
 *
 * @author hongghe 2018/12/28
 */
public enum ResultConst {

    SUCC(0, "success"),
    ERROR(-1, "param error")
    ;

    /**
     * The status code of api
     */
    private Integer code;

    /**
     * The message of api
     */
    private String msg;

    ResultConst(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

}
