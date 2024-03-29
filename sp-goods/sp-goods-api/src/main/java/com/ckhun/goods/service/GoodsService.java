package com.ckhun.goods.service;

import com.ckhun.goods.bo.goods.GoodsAddBO;
import com.ckhun.goods.bo.goods.GoodsAllInfoByCodeAndSkuBO;
import com.ckhun.goods.bo.goods.GoodsListBO;
import com.ckhun.goods.bo.goods.GoodsUpdateBO;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.vo.goods.GoodsGoodsAllInfoVO;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * create by one
 *
 * @Date 2021/1/30 16:50
 * @Description
 */
@FeignClient(name = "sp-goods")
public interface GoodsService {
    /**
     * 新增商品
     *
     * @param goodsAddBO
     * @return
     */
    @PostMapping("addGoods")
    public R<String> add(@RequestBody GoodsAddBO goodsAddBO);

    /**
     * 更新商品基本信息
     * @param goodsUpdateBO
     * @return
     */
    @PostMapping("updateGoods")
    public R<Boolean> update(@RequestBody GoodsUpdateBO goodsUpdateBO);

    /**
     * 通过code获取商品信息
     * @param goodsCode
     * @return
     */
    @GetMapping("byGoodsCode")
    public R<Goods> goodsByCode(@RequestParam("goodsCode") String goodsCode);


    /**
     * 分页返回
     * @param goodsListBO
     * @return
     */
    @PostMapping("listPage")
    public R<PageResult> listGoods(@RequestBody GoodsListBO goodsListBO);

    /**
     * 返回全家
     * @param goodsAllInfoByCodeAndSkuBO
     * @return
     */
    @PostMapping("getAllInfoByCodeAndSku")
    public R<GoodsGoodsAllInfoVO> allInfoByCodeAndSku(@RequestBody GoodsAllInfoByCodeAndSkuBO goodsAllInfoByCodeAndSkuBO);
}
