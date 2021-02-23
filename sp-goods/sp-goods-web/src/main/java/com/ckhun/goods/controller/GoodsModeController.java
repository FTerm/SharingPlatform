package com.ckhun.goods.controller;

import com.ckhun.goods.dto.goodsmode.GoodsModeAddDTO;
import com.ckhun.goods.dto.goodsmode.GoodsModeDelDTO;
import com.ckhun.goods.dto.goodsmode.GoodsModeUpdateDTO;
import com.ckhun.goods.pojo.GoodsMode;
import com.ckhun.goods.service.GoodsModeService;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/2/1 14:20
 * @Description
 */
@RestController
@RequestMapping("/goodsMode")
@Api(tags = "商品模式相关api")
public class GoodsModeController {

    @Autowired
    private GoodsModeService goodsModeService;

    @GetMapping("byGoodsCode")
    @ApiOperation(value = "获得商品模式",httpMethod = "GET")
    public R<List<GoodsMode>> getByGoodsCode(@RequestParam("goodsCode") String goodsCode){
        R<List<GoodsMode>> byGoodsCode = goodsModeService.getByGoodsCode(goodsCode);
        return byGoodsCode;
    }


}
