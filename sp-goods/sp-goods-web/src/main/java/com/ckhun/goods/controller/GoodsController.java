package com.ckhun.goods.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/1/30 16:56
 * @Description
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @ApiOperation(value = "添加", httpMethod = "POST")
    @RequestMapping("/add")
    public String hello() {
        return "1";
    }
}
