package com.ckhun.controller;

import com.ckhun.pojo.dto.OrdersUpdateStatusDTO;
import com.ckhun.service.OrdersService;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kunhong Chan
 * @date : Created in 13:52 2021/2/1
 * @description :
 * @since : 1.0.0
 * 相关接口如下
 * 1. 用户下单
 * 2. 用户关闭订单
 * 3. 用户获取订单信息
 * 4. 用户获取全部订单信息
 * 5. 用户删除单条订单记录
 * 6. 用户以租代售模式的一次性清空资金
 * 7.
 */
// TODO 控制器编写
@Api(tags = "用户订单服务接口")
@RestController
@RequestMapping("api")
public class ApiOrderController {

    @Autowired
    private OrdersService ordersService;

    @PutMapping("updateStatus")
    @ApiOperation(value = "更新订单状态", httpMethod = "PUT", notes = "更新订单的状态，这个接口用来处理一系列的状态")
    public R<?> hello(@RequestBody OrdersUpdateStatusDTO ordersUpdateStatusDTO) {
        return ordersService.updateOrderStatus(ordersUpdateStatusDTO);
    }
}
