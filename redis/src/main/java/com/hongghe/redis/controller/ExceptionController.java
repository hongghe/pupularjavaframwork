package com.hongghe.redis.controller;

import com.hongghe.redis.annotation.ForceLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongghe 2018/12/28
 */
@RestController
@Slf4j
@RequestMapping(value = "/error")
public class ExceptionController {

    @RequestMapping(value = "500")
    @ForceLogin
    public String ServerError() {
        return "500";
    }

    @RequestMapping(value = "404")
    public String NotFoundError() {
        return "404";
    }

}
