package com.ckhun.controller;

import com.ckhun.pojo.dto.EquityAddDTO;
import com.ckhun.pojo.dto.EquityDelDTO;
import com.ckhun.pojo.dto.EquityEditDTO;
import com.ckhun.service.EquityInfoService;
import com.ckhun.utils.PageRequest;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Kunhong Chan
 * @date : Created in 12:15 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Api(tags = "权益活动接口")
@RestController
@ResponseBody
@RequestMapping("marketing")
public class MarketingController {

    @Autowired
    private EquityInfoService equityInfoService;

    @PostMapping("add")
    @ApiOperation(value = "创建权益卡", httpMethod = "POST")
    public R<?> equityCreate(@RequestBody EquityAddDTO equityAddDTO) {
        return equityInfoService.createEquity(equityAddDTO);
    }

    @PutMapping("modification")
    @ApiOperation(value = "修改权益卡信息", httpMethod = "PUT")
    public R<?> equityModify(@RequestBody EquityEditDTO equityEditDTO) {
        return equityInfoService.modifyEquity(equityEditDTO);
    }

    @PostMapping("findPage")
    @ApiOperation(value = "分页返回数据", httpMethod = "POST")
    public PageResult findEquity(@RequestBody PageRequest pageRequest) {
        return equityInfoService.findEquityByPage(pageRequest);
    }

    @DeleteMapping("del")
    @ApiOperation(value = "删除权益卡", httpMethod = "DELETE")
    public R<?> delEquity(@RequestBody EquityDelDTO equityDelDTO) {
        return equityInfoService.delEquity(equityDelDTO.getEquityId());
    }


}
