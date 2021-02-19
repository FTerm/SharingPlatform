package com.ckhun.controller;

import com.ckhun.service.UserService;
import com.ckhun.utils.PageRequest;
import com.ckhun.utils.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:19 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Api(tags = "后台用户服务接口")
@ResponseBody
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("findPage")
    @ApiOperation(value = "分页返回数据", httpMethod = "POST")
    public PageResult findUser(@RequestBody PageRequest pageRequest) {
        return userService.getUserByPage(pageRequest);
    }



}
