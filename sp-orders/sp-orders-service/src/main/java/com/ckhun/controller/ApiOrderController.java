package com.ckhun.controller;

import com.ckhun.pojo.dto.OrdersAddDTO;
import com.ckhun.pojo.dto.OrdersUpdateStatusDTO;
import com.ckhun.pojo.vo.OrderListVo;
import com.ckhun.pojo.vo.OrdersVo;
import com.ckhun.service.OrdersService;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 13:52 2021/2/1
 * @description :
 * @since : 1.0.0
 */

@Api(tags = "用户订单服务接口")
@RestController
@RequestMapping("api/orders")
public class ApiOrderController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("create")
    @ApiOperation(value = "用户下单", httpMethod = "POST")
    public R<?> createOrders(@RequestBody OrdersAddDTO ordersAddDTO) {
        return ordersService.createOrder(ordersAddDTO);
    }

    @PostMapping("getById")
    @ApiOperation(value = "根据用户获取全部订单信息", httpMethod = "POST")
    @ApiImplicitParam(name = "userId", value = "userId", required = true, dataType = "int")
    public R<?> getOrdersByUser(@RequestBody Integer userId) {
        List<OrderListVo> orderByUser = ordersService.getOrderByUser(userId);
        return new R<>(ErrorEnum.HTTP_SUCCESS.getErrMsg(), orderByUser);
    }

    @PostMapping("getOrder")
    @ApiImplicitParam(name = "orderId", value = "orderId", required = true, dataType = "String")
    public R<?> getOrder(@RequestBody String orderId) {
        OrdersVo ordersVo = ordersService.queryById(orderId);
        return new R<>(ErrorEnum.HTTP_SUCCESS.getErrMsg(), ordersVo);
    }


    @PutMapping("updateStatus")
    @ApiOperation(value = "更新订单状态", httpMethod = "PUT", notes = "更新订单的状态，这个接口用来处理一系列的状态")
    public R<?> hello(@RequestBody OrdersUpdateStatusDTO ordersUpdateStatusDTO) {
        return ordersService.updateOrderStatus(ordersUpdateStatusDTO);
    }
}
