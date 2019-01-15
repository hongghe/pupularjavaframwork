package com.hongghe.aop.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-15 18:38
 */
@Slf4j
@RestController
@RequestMapping(path = "user_apply")
public class UserApplyController {

    @RequestMapping(value = "check")
    public boolean checkApply() {
        return true;
    }
}
