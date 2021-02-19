package com.ckhun.controller;

import com.ckhun.pojo.dto.UserAddDTO;
import com.ckhun.pojo.dto.UserChangePassword;
import com.ckhun.pojo.dto.UserDTO;
import com.ckhun.pojo.dto.UserEditDTO;
import com.ckhun.service.UserService;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:25 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Api(tags = "用户服务接口")
@ResponseBody
@RestController
@RequestMapping("api/user")
public class ApiUserController {

    @Autowired
    private UserService userService;

    @PostMapping("add")
    @ApiOperation(value = "注册用户", httpMethod = "POST")
    public R<?> createUser(@RequestBody UserAddDTO userAddDTO) {
        return userService.userAdd(userAddDTO);
    }

    @PostMapping("login")
    @ApiOperation(value = "用户登录", httpMethod = "POST")
    public R<?> login(@RequestBody UserDTO userDTO) {
        return userService.userLogin(userDTO);
    }

    @PutMapping("modification")
    @ApiOperation(value = "修改个人信息", httpMethod = "PUT")
    public R<?> modifyUser(@RequestBody UserEditDTO userEditDTO) {
        return userService.userModify(userEditDTO);
    }

    @PostMapping("profile")
    @ApiOperation(value = "获取个人信息", httpMethod = "POST")
    public R<?> profileUser(@RequestBody UserDTO userDTO) {
        return userService.profileUser(userDTO);
    }

    @PutMapping("changePassword")
    @ApiOperation(value = "修改密码", httpMethod = "PUT")
    public R<?> changePassword(@RequestBody UserChangePassword userChangePassword) {
        return userService.changePassword(userChangePassword);
    }

    @Deprecated
    @PostMapping("addBalance")
    @ApiOperation(value = "添加金额", httpMethod = "POST")
    public R<?> balanceAdd() {
        return new R<>();
    }
}
