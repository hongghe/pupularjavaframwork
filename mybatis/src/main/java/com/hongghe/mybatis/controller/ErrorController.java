package com.hongghe.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The web request exception
 *
 * @author hongghe 2019/1/4
 */
@Slf4j
@RestController
@RequestMapping(value = "/error")
public class ErrorController {

    @RequestMapping(value = "400")
    public String notFoundPage(HttpServletRequest request, HttpServletResponse response) {
        return "400";
    }

    @RequestMapping(value = "500")
    public String serverError(HttpServletRequest request, HttpServletResponse response) {
        return "500";
    }
}
