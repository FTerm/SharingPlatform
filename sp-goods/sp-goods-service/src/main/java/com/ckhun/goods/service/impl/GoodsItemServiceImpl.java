package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.common.AssertException;
import com.ckhun.goods.bo.goodsitem.*;
import com.ckhun.goods.mapper.GoodsItemMapper;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.pojo.GoodsItem;
import com.ckhun.goods.service.GoodsItemService;
import com.ckhun.goods.service.GoodsService;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;
import com.ckhun.utils.TimeUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * create by one
 *
 * @Date 2021/1/30 16:54
 * @Description
 */
@RestController
public class GoodsItemServiceImpl extends ServiceImpl<GoodsItemMapper, GoodsItem> implements GoodsItemService {

    @Autowired
    private GoodsServiceImpl goodsService;

    @Override
    @Transactional
    public R<Boolean> batchAdd(@RequestBody GoodsItemAddListBO goodsItemAddListBO) {
        AssertException.isTrue(!CollectionUtils.isEmpty(goodsItemAddListBO.getGoodsItemAddBOList()), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品项为空");
        AssertException.isNotBlank(goodsItemAddListBO.getGoodsCode(), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品编码为空");

        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<Goods>()
                .eq("goods_code", goodsItemAddListBO.getGoodsCode());

        Goods goods = goodsService.getOne(goodsQueryWrapper);
        AssertException.isNotNull(goods, ErrorEnum.VALIDATION_EOR.getErrCode(), "商品不存在");
        AssertException.isTrue(goods.getCount() >= (goods.getItemCount() + goodsItemAddListBO.getGoodsItemAddBOList().size()), ErrorEnum.FAIL.getErrCode(), "商品项数量大于总数量");

        List<GoodsItemAddBO> goodsItemAddBOList = goodsItemAddListBO.getGoodsItemAddBOList();
        int size = goodsItemAddBOList.size();
        /**
         * 更新商品项数量
         */
        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<Goods>()
                .eq("goods_code", goodsItemAddListBO.getGoodsCode())
                .eq("itemCount", goods.getItemCount())   //乐观锁
                .ge("count", goods.getItemCount() + size)
                .set("itemCount", goods.getItemCount() + size);

        boolean update = goodsService.update(updateWrapper);
        AssertException.isTrue(update, ErrorEnum.FAIL.getErrCode(), "更新商品数量失败");

        List<GoodsItem> goodsItems = new ArrayList<>();
        Long time = TimeUtil.getCreateTime();
        if (!CollectionUtils.isEmpty(goodsItemAddBOList)) {
            goodsItemAddBOList.stream().forEach((item) -> {
                GoodsItem goodsItem = new GoodsItem();
                BeanUtils.copyProperties(item, goodsItem);
                goodsItem.setGoodsCode(goodsItemAddListBO.getGoodsCode());
                goodsItem.setCreateTime(time);
                goodsItem.setUpdateTime(time);
            });
        }
        boolean b = this.saveBatch(goodsItems);
        AssertException.isTrue(b, ErrorEnum.FAIL.getErrCode(), "新增商品项失败");

        R<Boolean> r = new R<>();
        r.setData(Boolean.TRUE);
        return r;
    }

    @Override
    @Transactional
    public R<Boolean> updateGoodsItem(@RequestBody GoodsItemUpdateBO goodsItemUpdateBO) {
        AssertException.isNotBlank(goodsItemUpdateBO.getSku(), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品SKU为空");

        GoodsItem goodsItem = new GoodsItem();
        BeanUtils.copyProperties(goodsItemUpdateBO, goodsItem);

        UpdateWrapper<GoodsItem> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("sku", goodsItemUpdateBO.getSku());

        boolean update = this.update(goodsItem, updateWrapper);
        AssertException.isTrue(update, ErrorEnum.FAIL.getErrCode(), "更新失败");

        R<Boolean> result = new R<>();
        result.setData(update);
        return result;
    }

    @Override
    @Transactional
    public R<Boolean> remove(@RequestBody GoodsItemDeleteBO goodsItemDeleteBO) {
        AssertException.isTrue(!CollectionUtils.isEmpty(goodsItemDeleteBO.getSkuList()), ErrorEnum.FAIL.getErrCode(), "SKU集合为空");
        AssertException.isNotBlank(goodsItemDeleteBO.getGoodsCode(), ErrorEnum.FAIL.getErrCode(), "商品编码为空");

        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<Goods>()
                .eq("goods_code", goodsItemDeleteBO.getGoodsCode());
        Goods goods = goodsService.getOne(goodsQueryWrapper);
        AssertException.isNotNull(goods, ErrorEnum.FAIL.getErrCode(), "商品异常,商品不存在");

        int size = goodsItemDeleteBO.getSkuList().size();
        AssertException.isTrue(size <= goods.getItemCount(), ErrorEnum.FAIL.getErrCode(), "商品数量异常");

        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("goods_code",goods.getGoodsCode());
        updateWrapper.set("item_count",goods.getItemCount()-size);
        updateWrapper.apply("item_count = item_count"); //乐观锁
        boolean update = goodsService.update(updateWrapper);
        AssertException.isTrue(update,ErrorEnum.FAIL.getErrCode(),"更新数量失败");

        QueryWrapper<GoodsItem> goodsItemQueryWrapper = new QueryWrapper<>();
        goodsItemQueryWrapper.in("sku",goodsItemDeleteBO.getSkuList());
        boolean remove = this.remove(goodsItemQueryWrapper);
        AssertException.isTrue(remove,ErrorEnum.FAIL.getErrCode(),"删除失败");

        R<Boolean> result = new R<>();
        result.setData(remove);
        return result;
    }

    @Override
    public R<GoodsItem> itemBySku(@RequestParam("sku") String sku) {
        AssertException.isNotBlank(sku, ErrorEnum.VALIDATION_EOR.getErrCode(), "商品SKU为空");

        QueryWrapper<GoodsItem> goodsItemQueryWrapper = new QueryWrapper<GoodsItem>().eq("sku", sku);
        GoodsItem item = this.getOne(goodsItemQueryWrapper);
        AssertException.isNotNull(item, ErrorEnum.FAIL.getErrCode(), "商品项不存在");

        R<GoodsItem> goodsItemR = new R<>();
        goodsItemR.setData(item);
        return goodsItemR;
    }

    @Override
    public R<PageResult> itemListByGoodsCode(@RequestBody GoodsItemListBO goodsItemListBO) {
        AssertException.isNotNull(goodsItemListBO.getPageNum(),ErrorEnum.VALIDATION_EOR.getErrCode(),"PageNum为空");
        AssertException.isNotNull(goodsItemListBO.getPageSize(),ErrorEnum.VALIDATION_EOR.getErrCode(),"PageSize为空");
        AssertException.isNotNull(goodsItemListBO.getGoodsCode(),ErrorEnum.VALIDATION_EOR.getErrCode(),"商品编码为空");

        Page<GoodsItem> page = new Page<>(goodsItemListBO.getPageNum(),goodsItemListBO.getPageSize());

        QueryWrapper<GoodsItem> queryWrapper = new QueryWrapper<GoodsItem>()
                .eq("goods_code",goodsItemListBO.getGoodsCode());

        if (StringUtils.isNotBlank(goodsItemListBO.getLatitude())){
            queryWrapper.eq("latitude",goodsItemListBO.getLatitude());
        }
        if (StringUtils.isNotBlank(goodsItemListBO.getLongitude())){
            queryWrapper.eq("longitude",goodsItemListBO.getLongitude());
        }
        if (StringUtils.isNotBlank(goodsItemListBO.getSku())){
            queryWrapper.eq("sku",goodsItemListBO.getSku());
        }

        PageResult pageResult = new PageResult();
        Page<GoodsItem> gPage = this.page(page, queryWrapper);

        pageResult.setPageNum(goodsItemListBO.getPageNum());
        pageResult.setPageSize(goodsItemListBO.getPageSize());
        pageResult.setResults(gPage.getRecords());
        pageResult.setTotalSize(gPage.getTotal());

        R<PageResult> resultR = new R<>();
        resultR.setData(pageResult);
        return resultR;
    }
}
