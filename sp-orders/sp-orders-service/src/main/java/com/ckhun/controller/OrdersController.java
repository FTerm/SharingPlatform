package com.ckhun.controller;

import com.ckhun.handler.StateHandler;
import com.ckhun.pojo.dto.OrdersUpdateDTO;
import com.ckhun.pojo.vo.OrderListVo;
import com.ckhun.service.OrdersService;
import com.ckhun.utils.*;
import com.ckhun.pojo.dto.OrdersAddDTO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private OrdersService ordersService;

    @PostMapping("findPage")
    @ApiOperation(value = "分页返回数据", httpMethod = "POST")
    public PageResult findOrders(@RequestBody PageRequest pageRequest) {
        return ordersService.selectOrderByPage(pageRequest);
    }

    @GetMapping("findAll")
    @ApiOperation(value = "获取全部订单信息", httpMethod = "GET")
    public R<?> getAllOrders() {
        List<OrderListVo> allOrder = ordersService.getAllOrder();
        return new R<>(ErrorEnum.HTTP_SUCCESS.getErrMsg(), allOrder);
    }


    @Deprecated
    @PutMapping("modify")
    public R<?> modifyOrder(@RequestBody OrdersUpdateDTO ordersUpdateDTO) {
        return new R<>();
    }

}
