package com.ckhun.goods.controller;

import com.ckhun.goods.dto.mode.ModeAddDTO;
import com.ckhun.goods.dto.mode.ModeDeleteDTO;
import com.ckhun.goods.dto.mode.ModeUpdateDTO;
import com.ckhun.goods.pojo.Mode;
import com.ckhun.goods.service.ModeService;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/1/30 16:56
 * @Description 前端控制器
 */
@RestController
@RequestMapping("/mode")
@Api(tags = "模式相关api")
public class ModeController {

    @Autowired
    private ModeService modeService;


    @GetMapping("byId")
    @ApiOperation(value = "根据id获取mode",httpMethod = "GET")
    public R<Mode> getModeById(@RequestParam("id") Integer id){
        R<Mode> modeById = modeService.getModeById(id);
        return modeById;
    }

    @GetMapping("list")
    @ApiOperation(value = "list",httpMethod = "GET")
    public R<List<Mode>> listMode(){
        R<List<Mode>> listR = modeService.listMode();
        return listR;
    }
}
