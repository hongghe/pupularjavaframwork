package com.hongghe.aop.controller.company;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-15 18:39
 */
@Slf4j
@RestController
@RequestMapping(path = "company_login")
public class CompanyLoginController {

    @RequestMapping(value = "check")
    public boolean loginCheck() {
        return true;
    }
}
