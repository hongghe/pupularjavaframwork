package com.hongghe.ablibabacloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-13 16:07
 */
@Slf4j
@RestController
@RequestMapping(path = "/exception")
public class ExceptionController {

    @RequestMapping(value = "404")
    public String notFound() {
        return "404";
    }
}
