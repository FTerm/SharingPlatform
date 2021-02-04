package com.ckhun.goods.service;

import com.ckhun.goods.bo.goodsitem.GoodsItemAddListBO;
import com.ckhun.goods.bo.goodsitem.GoodsItemDeleteBO;
import com.ckhun.goods.bo.goodsitem.GoodsItemListBO;
import com.ckhun.goods.bo.goodsitem.GoodsItemUpdateBO;
import com.ckhun.goods.pojo.GoodsItem;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by one
 *
 * @Date 2021/1/30 16:50
 * @Description
 */
@FeignClient(name = "sp-goods")
public interface GoodsItemService {

    /**
     * 批量插入
     * @param goodsItemAddListBO
     * @return
     */
    @PostMapping("batchAdd")
    public R<Boolean> batchAdd(@RequestBody GoodsItemAddListBO goodsItemAddListBO);

    /**
     * 更新信息
     * @param goodsItemUpdateBO
     * @return
     */
    @PostMapping("updateGoodsItem")
    public R<Boolean> updateGoodsItem(@RequestBody GoodsItemUpdateBO goodsItemUpdateBO);

    /**
     * 批量删除
     * @param goodsItemDeleteBO
     * @return
     */
    @PostMapping("delGoodsItem")
    public R<Boolean> remove(@RequestBody GoodsItemDeleteBO goodsItemDeleteBO);

    /**
     * 通过sku获取商品项信息
     * @param sku
     * @return
     */
    @GetMapping("bySku")
    public R<GoodsItem> itemBySku (@RequestParam("sku") String sku);

    /**
     * 通过goodsCode获得goodsItem
     * @param goodsItemListBO
     * @return
     */

    @PostMapping("byGoodsCode")
    public R<PageResult> itemListByGoodsCode (@RequestBody GoodsItemListBO goodsItemListBO);

}
