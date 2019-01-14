package com.hongghe.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hongghe @date: 2019-01-14 15:34
 */
@Slf4j
@RestController
@RequestMapping(path = "/internal")
public class InternalController {

    @RequestMapping(value = "customer")
    public void customer() {
        //
    }
}
