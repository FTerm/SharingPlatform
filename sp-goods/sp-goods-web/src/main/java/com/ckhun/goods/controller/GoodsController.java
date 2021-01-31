package com.ckhun.goods.controller;

import com.ckhun.goods.bo.goods.GoodsAddBO;
import com.ckhun.goods.dto.goods.GoodsAddDTO;
import com.ckhun.goods.service.GoodsService;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/1/30 16:56
 * @Description 前端控制器
 */
@RestController
@RequestMapping("/goods")
@Api("商品相关api")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("add")
    @ApiOperation(value = "新增商品",httpMethod = "POST")
    public R<String> addGoods(@RequestBody GoodsAddDTO goodsAddDTO){

        GoodsAddBO goodsAddBO = new GoodsAddBO();
        BeanUtils.copyProperties(goodsAddDTO,goodsAddBO);

        R<String> result = goodsService.add(goodsAddBO);
        return result;
    }

    @PostMapping("update")
    @ApiOperation(value = "更新商品",httpMethod = "POST")
    public R<Boolean> updateGoods(){
        return null;
    }

}
