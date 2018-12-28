package com.hongghe.redis.controller.v1.user;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongghe 2018/12/28
 */
@Slf4j
@RestController
@RequestMapping(value = "/user/register")
@Api(value = "Register", description = "user register")
public class RegisterController {
}
