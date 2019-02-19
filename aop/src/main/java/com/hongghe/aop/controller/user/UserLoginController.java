package com.hongghe.aop.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-15 18:36
 */
@Slf4j
@RestController
@RequestMapping(path = "/user_login")
public class UserLoginController {

    /**
     * <p>用户的登录</p>
     * @return 登录的结果信息
     */
    @RequestMapping(value = "login")
    public boolean login() {
        return false;
    }
}
