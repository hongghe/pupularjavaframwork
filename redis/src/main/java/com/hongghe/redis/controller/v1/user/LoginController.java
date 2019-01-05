package com.hongghe.redis.controller.v1.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The user login app.
 *
 * @author hongghe 2018/12/28
 */
@Slf4j
@RestController
@RequestMapping(value = "/v1/login")
@Api(value = "Login", description = "user login")
public class LoginController {

    @RequestMapping(value = "check_login")
    @ApiOperation(value = "login", notes = "login")
    public boolean checkLogin() {
        return true;
    }

}
