package com.ckhun.goods.controller.back;

import com.ckhun.goods.bo.goods.GoodsAddBO;
import com.ckhun.goods.bo.goods.GoodsUpdateBO;
import com.ckhun.goods.bo.goodsitem.GoodsItemAddListBO;
import com.ckhun.goods.dto.goods.GoodsAddDTO;
import com.ckhun.goods.dto.goods.GoodsUpdateDTO;
import com.ckhun.goods.dto.goodsitem.GoodsItemAddListDTO;
import com.ckhun.goods.dto.goodsitem.GoodsItemDeleteDTO;
import com.ckhun.goods.dto.goodsitem.GoodsItemUpdateDTO;
import com.ckhun.goods.dto.goodsmode.GoodsModeAddDTO;
import com.ckhun.goods.dto.goodsmode.GoodsModeDelDTO;
import com.ckhun.goods.dto.goodsmode.GoodsModeUpdateDTO;
import com.ckhun.goods.service.GoodsItemService;
import com.ckhun.goods.service.GoodsModeService;
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
 * @Date 2021/2/23 12:50
 * @Description
 */
@RestController
@RequestMapping("goods—back")
@Api(tags = "商品相关后台Api")
public class GoodsBackController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsItemService goodsItemService;

    @Autowired
    private GoodsModeService goodsModeService;

    /**********************************商品****************************************/
    @PostMapping("addGoods")
    @ApiOperation(value = "新增商品",httpMethod = "POST")
    public R<String> addGoods(@RequestBody GoodsAddDTO goodsAddDTO){

        GoodsAddBO goodsAddBO = new GoodsAddBO();
        BeanUtils.copyProperties(goodsAddDTO,goodsAddBO);

        R<String> result = goodsService.add(goodsAddBO);
        return result;
    }

    @PostMapping("updateGoods")
    @ApiOperation(value = "更新商品",httpMethod = "POST")
    public R<Boolean> updateGoods(@RequestBody GoodsUpdateDTO goodsUpdateDTO){

        GoodsUpdateBO goodsUpdateBO = new GoodsUpdateBO();
        BeanUtils.copyProperties(goodsUpdateDTO,goodsUpdateBO);

        R<Boolean> update = goodsService.update(goodsUpdateBO);
        return update;
    }

    /**********************************商品项目****************************************/
    @PostMapping("batchAddGoodsItem")
    @ApiOperation(value = "批量新增商品项",httpMethod = "POST")
    public R<Boolean> batchAdd(@RequestBody GoodsItemAddListDTO goodsItemAddListDTO) {

        GoodsItemAddListBO goodsItemAddListBO = new GoodsItemAddListBO();
        goodsItemAddListBO.setGoodsCode(goodsItemAddListDTO.getGoodsCode());
        goodsItemAddListBO.setGoodsItemAddBOList(goodsItemAddListDTO.getGoodsItemAddBOList());

        R<Boolean> booleanR = goodsItemService.batchAdd(goodsItemAddListBO);

        return booleanR;
    }

    @PostMapping("updateGoodsItem")
    @ApiOperation(value = "更新商品项",httpMethod = "POST")
    public R<Boolean> updateGoodsItem(@RequestBody GoodsItemUpdateDTO goodsItemUpdateDTO){
        R<Boolean> booleanR = goodsItemService.updateGoodsItem(goodsItemUpdateDTO);
        return booleanR;
    }

    @PostMapping("delGoodsItem")
    @ApiOperation(value = "删除商品项",httpMethod = "POST")
    public R<Boolean> remove(@RequestBody GoodsItemDeleteDTO goodsItemDeleteDTO){
        R<Boolean> remove = goodsItemService.remove(goodsItemDeleteDTO);
        return remove;
    }

    /************************************商品模式****************************************/

    @PostMapping("addGoodsMode")
    @ApiOperation(value = "新增商品模式",httpMethod = "POST")
    public R<Boolean> addGoodsMode(@RequestBody GoodsModeAddDTO goodsModeAddDTO){
        R<Boolean> booleanR = goodsModeService.addGoodsMode(goodsModeAddDTO);
        return booleanR;
    }

    @PostMapping("delGoodsMode")
    @ApiOperation(value = "删除商品模式",httpMethod = "POST")
    public R<Boolean> delGoodsMode(@RequestBody GoodsModeDelDTO goodsModeDelDTO){
        R<Boolean> booleanR = goodsModeService.delGoodsMode(goodsModeDelDTO);
        return booleanR;
    }

    @PostMapping("updateGoodsMode")
    @ApiOperation(value = "更新商品模式",httpMethod = "POST")
    public R<Boolean> updateGoodsMode(@RequestBody GoodsModeUpdateDTO goodsModeUpdateDTO){
        R<Boolean> booleanR = goodsModeService.updateGoodsMode(goodsModeUpdateDTO);
        return booleanR;
    }
}
