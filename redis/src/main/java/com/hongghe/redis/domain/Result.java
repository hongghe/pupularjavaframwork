package com.hongghe.redis.domain;

import lombok.Data;

/**
 * @author hongghe 2018/12/28
 */
@Data
public class Result<T> {

    /**
     * The status code of api
     */
    public Integer code = ResultConst.SUCC.getCode();

    /**
     * The message of api.
     */
    public String msg = ResultConst.SUCC.getMsg();

    public T data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(ResultConst resultConst) {
        this.code = resultConst.getCode();
        this.msg = resultConst.getMsg();
    }

    public <Response> Result of(Response response) {
        return new Result(response);
    }
}
