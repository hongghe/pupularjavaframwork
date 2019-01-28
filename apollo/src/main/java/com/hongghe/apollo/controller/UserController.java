package com.hongghe.apollo.controller;

import com.google.gson.Gson;
import com.hongghe.apollo.config.AdminProperties;
import com.hongghe.apollo.domain.UserType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author: hongghe @date: 2019-01-12 16:45
 */
@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private AdminProperties adminConfig;

    @PostConstruct
    public void init() {
        System.out.println(new Gson().toJson(adminConfig));
    }

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
