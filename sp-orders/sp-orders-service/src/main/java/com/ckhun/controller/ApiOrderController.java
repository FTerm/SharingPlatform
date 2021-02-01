package com.ckhun.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Kunhong Chan
 * @date : Created in 13:52 2021/2/1
 * @description :
 * @since : 1.0.0
 * 相关接口如下
 * 1. 用户下单
 * 2. 用户结束订单
 * 3. 用户获取订单信息
 * 4. 用户获取全部订单信息
 * 5. 用户删除单条订单记录
 */
@Api(tags = "用户订单服务接口")
@RestController
@RequestMapping("api")
public class ApiOrderController {

    @GetMapping()
    public String  hello() {
        return "s";
    }
}
