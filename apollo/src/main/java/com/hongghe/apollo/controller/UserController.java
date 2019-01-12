package com.hongghe.apollo.controller;

import com.hongghe.apollo.domain.UserType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-12 16:45
 */
@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @RequestMapping(value = "{userType}")
    public boolean userAuthorization(@PathVariable(value = "userType")UserType userType) {
        switch (userType) {
            case ADMIN:
                return true;
            case STUDENT:
                return false;
            case TEACHER:
                return true;
                default:
                    return false;
        }
    }
}
