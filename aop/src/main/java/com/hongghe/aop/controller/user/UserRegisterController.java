package com.hongghe.aop.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-15 18:34
 */
@Slf4j
@RestController
@RequestMapping(path = "/user_register")
public class UserRegisterController {

    @RequestMapping(value = "check")
    public boolean check() {
        return false;
    }

    @RequestMapping(value = "register")
    public boolean register() {
        return false;
    }
}
