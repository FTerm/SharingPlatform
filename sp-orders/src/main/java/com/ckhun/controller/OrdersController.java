package com.ckhun.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Kunhong Chan
 * @date : Created in 10:08 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Api(tags = "订单服务接口")
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @GetMapping("/get")
    public String hello() {
        return "success";
    }
}
