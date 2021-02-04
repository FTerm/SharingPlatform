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
@Api("商品模式相关api")
public class GoodsModeController {

    @Autowired
    private GoodsModeService goodsModeService;

    @PostMapping("add")
    @ApiOperation(value = "新增商品模式",httpMethod = "POST")
    public R<Boolean> addGoodsMode(@RequestBody GoodsModeAddDTO goodsModeAddDTO){
        R<Boolean> booleanR = goodsModeService.addGoodsMode(goodsModeAddDTO);
        return booleanR;
    }

    @PostMapping("del")
    @ApiOperation(value = "删除商品模式",httpMethod = "POST")
    public R<Boolean> delGoodsMode(@RequestBody GoodsModeDelDTO goodsModeDelDTO){
        R<Boolean> booleanR = goodsModeService.delGoodsMode(goodsModeDelDTO);
        return booleanR;
    }

    @PostMapping("update")
    @ApiOperation(value = "更新商品模式",httpMethod = "POST")
    public R<Boolean> updateGoodsMode(@RequestBody GoodsModeUpdateDTO goodsModeUpdateDTO){
        R<Boolean> booleanR = goodsModeService.updateGoodsMode(goodsModeUpdateDTO);
        return booleanR;
    }

    @GetMapping("byGoodsCode")
    @ApiOperation(value = "获得商品模式",httpMethod = "GET")
    public R<List<GoodsMode>> getByGoodsCode(@RequestParam("goodsCode") String goodsCode){
        R<List<GoodsMode>> byGoodsCode = goodsModeService.getByGoodsCode(goodsCode);
        return byGoodsCode;
    }


}
