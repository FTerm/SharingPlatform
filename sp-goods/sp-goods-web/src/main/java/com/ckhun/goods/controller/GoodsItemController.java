package com.ckhun.goods.controller;

import com.ckhun.goods.bo.goodsitem.GoodsItemAddListBO;
import com.ckhun.goods.dto.goodsitem.GoodsItemAddListDTO;
import com.ckhun.goods.dto.goodsitem.GoodsItemDeleteDTO;
import com.ckhun.goods.dto.goodsitem.GoodsItemListDTO;
import com.ckhun.goods.dto.goodsitem.GoodsItemUpdateDTO;
import com.ckhun.goods.pojo.GoodsItem;
import com.ckhun.goods.service.GoodsItemService;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * create by one
 *
 * @Date 2021/2/1 14:47
 * @Description
 */
@RestController
@RequestMapping("/goodsItem")
@Api(tags = "商品项相关api")
public class GoodsItemController {

    @Autowired
    private GoodsItemService goodsItemService;

    @GetMapping("bySku")
    @ApiOperation(value = "获得商品项信息",httpMethod = "GET")
    public R<GoodsItem> itemBySku(@RequestParam("sku") String sku){
        R<GoodsItem> goodsItemR = goodsItemService.itemBySku(sku);
        return goodsItemR;
    }

    @PostMapping("byGoodsCode")
    @ApiOperation(value = "分页list",httpMethod = "POST")
    public R<PageResult> itemListByGoodsCode(@RequestBody GoodsItemListDTO goodsItemListDTO){
        R<PageResult> resultR = goodsItemService.itemListByGoodsCode(goodsItemListDTO);
        return resultR;
    }

}
