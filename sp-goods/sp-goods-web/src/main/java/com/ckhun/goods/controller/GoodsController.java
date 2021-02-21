package com.ckhun.goods.controller;

import com.ckhun.goods.bo.goods.GoodsAddBO;
import com.ckhun.goods.bo.goods.GoodsUpdateBO;
import com.ckhun.goods.dto.goods.GoodsAddDTO;
import com.ckhun.goods.dto.goods.GoodsListDTO;
import com.ckhun.goods.dto.goods.GoodsUpdateDTO;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.service.GoodsService;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * create by one
 *
 * @Date 2021/1/30 16:56
 * @Description 前端控制器
 */
@RestController
@RequestMapping("/goods")
@Api(tags = "商品相关api")
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
    public R<Boolean> updateGoods(@RequestBody GoodsUpdateDTO goodsUpdateDTO){

        GoodsUpdateBO goodsUpdateBO = new GoodsUpdateBO();
        BeanUtils.copyProperties(goodsUpdateDTO,goodsUpdateBO);

        R<Boolean> update = goodsService.update(goodsUpdateBO);
        return update;
    }

    @GetMapping("getByCode")
    @ApiOperation(value = "根据code获取商品",httpMethod = "GET")
    public R<Goods> goodsByCode(@RequestParam("goodsCode") String goodsCode){
        R<Goods> r = goodsService.goodsByCode(goodsCode);
        return r;
    }


    @PostMapping("list")
    @ApiOperation(value = "分页",httpMethod = "POST")
    public R<PageResult> listGoods(@RequestBody GoodsListDTO goodsListDTO){
        R<PageResult> resultR = goodsService.listGoods(goodsListDTO);
        return resultR;
    }
}
