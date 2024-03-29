package com.ckhun.controller;

import io.swagger.annotations.Api;
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
@Api(tags = "用户接口文档")
public class HelloController {

    /**
     * 新增用户信息
     * @return
     */
    @ApiOperation(value = "新增用户信息", httpMethod = "GET")
    @GetMapping("add")
    public String add() {
        return "success";
    }
}
