package com.hongghe.redis.domain;

import lombok.Data;

/**
 * @author hongghe 2018/12/28
 */
@Data
public class Result {

    /**
     * The status code of api
     */
    private Integer code = ResultConst.SUCC.getCode();

    /**
     * The message of api.
     */
    private String msg = ResultConst.SUCC.getMsg();

    public Result(ResultConst resultConst) {
        this.code = resultConst.getCode();
        this.msg = resultConst.getMsg();
    }

}
