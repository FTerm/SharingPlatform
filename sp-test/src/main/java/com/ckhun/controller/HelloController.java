package com.ckhun.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Kunhong Chan
 * @date : Created in 22:27 2021/1/30
 * @description :
 * @since : 1.0.0
 */

@RestController
@RequestMapping("/user")
public class HelloController {

    /**
     * 新增用户信息
     * @return
     */
    @ApiOperation(value = "新增用户信息", httpMethod = "POST")
    @GetMapping("add")
    public String add() {
        return "success";
    }
}
