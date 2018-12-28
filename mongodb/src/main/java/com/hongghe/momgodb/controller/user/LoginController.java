package com.hongghe.momgodb.controller.user;

import com.hongghe.momgodb.domain.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hongghe 2018/12/28
 */
@Slf4j
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @ApiOperation(value = "")
    public Result login(@RequestParam String username) {
        return new Result();
    }
}
