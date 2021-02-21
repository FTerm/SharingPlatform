package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.common.AssertException;
import com.ckhun.goods.bo.goods.GoodsAddBO;
import com.ckhun.goods.bo.goods.GoodsListBO;
import com.ckhun.goods.bo.goods.GoodsUpdateBO;
import com.ckhun.goods.consts.StatusConsts;
import com.ckhun.goods.mapper.GoodsMapper;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.service.GoodsService;
import com.ckhun.utils.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/1/30 16:54
 * @Description
 */
@RestController
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Override
    @Transactional
    public R<String> add(@RequestBody GoodsAddBO goodsAddBO) {
        //验参
        AssertException.isNotBlank(goodsAddBO.getName(),ErrorEnum.VALIDATION_EOR.getErrCode(),"商品名称为空");
        AssertException.isNotNull(goodsAddBO.getStauts(),ErrorEnum.VALIDATION_EOR.getErrCode(),"商品状态为空");
        AssertException.isNotBlank(goodsAddBO.getUnit(),ErrorEnum.VALIDATION_EOR.getErrCode(),"商品单位为空");
        AssertException.isNotNull(goodsAddBO.getType(),ErrorEnum.VALIDATION_EOR.getErrCode(),"商品类型为空");
        AssertException.isNotBlank(goodsAddBO.getVendorCode(),ErrorEnum.VALIDATION_EOR.getErrCode(),"所属商家编码为空");

        R<String> result = new R<>();
        //TODO 验证商家是否存在

        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsAddBO,goods);

        //生成商品编号
        String goodsCode = this.genGoodsCode();
        Long time = TimeUtil.getCreateTime();

        goods.setGoodsCode(goodsCode);
        goods.setDelFlag(TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        goods.setItemCount(0);  //商品项数量初始为0
        goods.setCreateTime(time);
        goods.setUpdateTime(time);
        goods.setStatus(StatusConsts.WAIT_STATUS);  //新增

        boolean save = this.save(goods);
        AssertException.isTrue(save,ErrorEnum.CREATE_EOR.getErrCode(),ErrorEnum.CREATE_EOR.getErrMsg());

        result.setData(goodsCode);

        return result;
    }

    /**
     * 更新商品基本信息
     * @param goodsUpdateBO
     * @return
     */
    @Override
    @Transactional
    public R<Boolean> update(@RequestBody GoodsUpdateBO goodsUpdateBO) {
        //验参
        AssertException.isNotBlank(goodsUpdateBO.getGoodsCode(),ErrorEnum.VALIDATION_EOR.getErrCode(),"商品编码为空");

        if (StringUtils.isNotBlank(goodsUpdateBO.getVendorCode())){
            // TODO 验证商家
        }

        //TODO 状态更新验参

        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsUpdateBO,goods);
        goods.setUpdateTime(TimeUtil.getCreateTime());
        UpdateWrapper<Goods> goodsUpdateWrapper = new UpdateWrapper<>();
        goodsUpdateWrapper.eq("goods_code",goods.getGoodsCode());

        boolean update = this.update(goods, goodsUpdateWrapper);
        AssertException.isTrue(update,ErrorEnum.UPDATE_EOR.getErrCode(),ErrorEnum.UPDATE_EOR.getErrMsg());
        R<Boolean> res = new R<Boolean>();
        res.setData(update);
        return res;
    }

    @Override
    public R<Goods> goodsByCode(@RequestParam("goodsCode") String goodsCode) {
        AssertException.isNotBlank(goodsCode,ErrorEnum.VALIDATION_EOR.getErrCode(),"商品编码为空");
        R<Goods> result = new R<>();

        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_code",goodsCode);
        queryWrapper.eq("del_flag",TrueOrFalseEnum.FALSE_STAUTS.getFlag());
        queryWrapper.ne("status", StatusConsts.DELETE_STATUS);  //查询出未删除的商品

        Goods goods = this.getOne(queryWrapper);

        result.setData(goods);
        return result;
    }
//
//    @Override
//    @Transactional
//    public R<Boolean> updateGoodsCount(@RequestBody GoodsUpdateCountBO updateCountBO) {
//        AssertException.isNotBlank(updateCountBO.getGoodsCode(),ErrorEnum.VALIDATION_EOR.getErrCode(),"商品编码为空");
//        AssertException.isNotNull(updateCountBO.getCount(),ErrorEnum.VALIDATION_EOR.getErrCode(),"商品数量为空");
//
//        QueryWrapper<Goods> queryWrapper = new QueryWrapper<Goods>()
//                .eq("goods_code",updateCountBO.getGoodsCode())
//                .eq("del_flag",TrueOrFalseEnum.FALSE_STAUTS.getFlag());
//        Goods goods = this.getOne(queryWrapper);
//        AssertException.isNotNull(goods,ErrorEnum.FAIL.getErrCode(),"商品不存在");
//        AssertException.isTrue(updateCountBO.getCount()>=goods.getItemCount(),ErrorEnum.UPDATE_EOR.getErrCode(),"商品总数量小于商品项数量");
//
//        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<Goods>()
//                .eq("goods_code",updateCountBO.getGoodsCode())
//                .le("item_count",updateCountBO.getCount())
//                .set("count",updateCountBO.getCount())
//                .set("update_time", TimeUtil.getCreateTime());
//        boolean update = this.update(updateWrapper);
//        AssertException.isTrue(update,ErrorEnum.UPDATE_EOR.getErrCode(),ErrorEnum.UPDATE_EOR.getErrMsg());
//
//        return new R<Boolean>();
//    }

    @Override
    public R<PageResult> listGoods(@RequestBody GoodsListBO goodsListBO) {
        AssertException.isNotNull(goodsListBO.getPageNum(),ErrorEnum.VALIDATION_EOR.getErrCode(),"PageNum为空");
        AssertException.isNotNull(goodsListBO.getPageSize(),ErrorEnum.VALIDATION_EOR.getErrCode(),"PageSize为空");

        Page<Goods> page = new Page<>(goodsListBO.getPageNum(),goodsListBO.getPageSize());
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<>();
        goodsQueryWrapper.eq("del_flag",TrueOrFalseEnum.FALSE_STAUTS.getFlag());
        if (goodsListBO.getStartTime()!=null){
            AssertException.isNotNull(goodsListBO.getEndTime(),ErrorEnum.VALIDATION_EOR.getErrCode(),"结束时间为空");
            goodsQueryWrapper.between("create_time",goodsListBO.getStartTime(),goodsListBO.getEndTime());
        }
        if (StringUtils.isNotBlank(goodsListBO.getName())){
            goodsQueryWrapper.like("name",goodsListBO.getName());
        }
        if (goodsListBO.getStauts()!=null){
            goodsQueryWrapper.eq("status",goodsListBO.getStauts());
        }
        if (goodsListBO.getType()!=null){
            goodsQueryWrapper.eq("type",goodsListBO.getType());
        }
        if (StringUtils.isNotBlank(goodsListBO.getVendorCode())){
            goodsQueryWrapper.like("vendor_code",goodsListBO.getVendorCode());
        }

        Page<Goods> gPage = this.page(page, goodsQueryWrapper);

        PageResult pageResult = new PageResult();
        pageResult.setPageNum(goodsListBO.getPageNum());
        pageResult.setPageSize(goodsListBO.getPageSize());
        pageResult.setResults(gPage.getRecords());
        pageResult.setTotalSize(gPage.getTotal());

        R<PageResult> resultR = new R<>();
        resultR.setData(pageResult);
        return resultR;
    }



    private String genGoodsCode() {
        String code = "GD" + System.currentTimeMillis() + RandomStringUtils.random(4, "1234567890");
        return code;
    }
}
