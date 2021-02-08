package com.ckhun.controller;

import com.ckhun.pojo.dto.AdminAddDTO;
import com.ckhun.pojo.dto.AdminLoginDTO;
import com.ckhun.service.AdminService;
import com.ckhun.utils.PageRequest;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:21 2021/2/8
 * @description :
 * @since : 1.0.0

 */
@Api("管理员模块")
@RestController
@RequestMapping("admin")
@ResponseBody
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("add")
    @ApiOperation(value = "添加管理员", httpMethod = "POST")
    public R<?> addAdmin(@RequestBody AdminAddDTO adminAddDTO) {
        return adminService.insertAdmin(adminAddDTO);
    }

    @Deprecated
    @PutMapping("modification")
    @ApiOperation(value = "编辑管理员", httpMethod = "PUT")
    public R<?> modifyAdmin() {
        return adminService.updateAdmin();
    }

    @PostMapping("findPage")
    @ApiOperation(value = "分页获取管理员", httpMethod = "POST")
    public PageResult findAdmin(@RequestBody PageRequest pageRequest) {
        return adminService.selectAdminByPage(pageRequest);
    }

    @DeleteMapping("del")
    @ApiOperation(value = "删除管理员", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    public R<?> delAdmin(@RequestBody Integer id) {
        return adminService.delAdmin(id);
    }

    @PostMapping("login")
    @ApiOperation(value = "管理员登录", httpMethod = "POST")
    public R<?> loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO) {
        return adminService.loginAdmin(adminLoginDTO);
    }

    @PostMapping("profile")
    @ApiOperation("管理员个人信息")
    public R<?> profileAdmin(@RequestBody AdminLoginDTO adminLoginDTO) {
        return adminService.profileAdmin(adminLoginDTO);
    }

}
