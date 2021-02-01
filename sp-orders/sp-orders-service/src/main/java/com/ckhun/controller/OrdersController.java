package com.ckhun.controller;

import com.ckhun.service.OrdersService;
import com.ckhun.utils.R;
import com.ckhun.pojo.dto.OrdersAddDTO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kunhong Chan
 * @date : Created in 10:08 2021/1/31
 * @description :
 * @since : 1.0.0
 * 相关接口如下：
 * 1. 分页获取订单信息
 * 2. 获取单条订单信息
 * 3. 更新订单状态
 *
 */
@Api(tags = "订单服务接口")
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("add")
    @ApiOperation(value = "创建订单信息", httpMethod = "POST", notes = "创建订单")
    public R<String> createOrders(@RequestBody OrdersAddDTO ordersAddDTO) {
        ordersService.createOrder(ordersAddDTO);
        return null;
    }
}
