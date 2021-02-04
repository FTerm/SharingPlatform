package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.common.AssertException;
import com.ckhun.goods.bo.goodsmode.GoodsModeAddBO;
import com.ckhun.goods.bo.goodsmode.GoodsModeDelBO;
import com.ckhun.goods.bo.goodsmode.GoodsModeUpdateBO;
import com.ckhun.goods.mapper.GoodsModeMapper;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.pojo.GoodsMode;
import com.ckhun.goods.pojo.Mode;
import com.ckhun.goods.service.GoodsModeService;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.R;
import com.ckhun.utils.TimeUtil;
import com.ckhun.utils.TrueOrFalseEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/1/30 16:54
 * @Description
 */
@RestController
@RequestMapping("goodsModeApi")
public class GoodsModeServiceImpl extends ServiceImpl<GoodsModeMapper, GoodsMode> implements GoodsModeService {

    @Autowired
    private GoodsServiceImpl goodsService;

    @Autowired
    private ModeServiceImpl modeService;

    @Override
    public R<Boolean> addGoodsMode(@RequestBody GoodsModeAddBO goodsModeAddBO) {
        AssertException.isNotBlank(goodsModeAddBO.getGoodsCode(), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品编码为空");
        AssertException.isNotNull(goodsModeAddBO.getModeId(), ErrorEnum.VALIDATION_EOR.getErrCode(), "模式id为空");
        AssertException.isNotNull(goodsModeAddBO.getPrice(), ErrorEnum.VALIDATION_EOR.getErrCode(), "价格为空");
        AssertException.isNotNull(goodsModeAddBO.getStatus(), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品状态为空");
        AssertException.isNotNull(goodsModeAddBO.getTarget(), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品模式期望价格为空");

        //商品验证
        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<Goods>()
                .eq("goods_code", goodsModeAddBO.getGoodsCode());
        Goods goods = goodsService.getOne(goodsQueryWrapper);
        AssertException.isNotNull(goods, ErrorEnum.FAIL.getErrCode(), "商品不存在");

        //模式验证
        Mode mode = modeService.getById(goodsModeAddBO.getModeId());
        AssertException.isNotNull(mode, ErrorEnum.FAIL.getErrCode(), "模式不存在");

        GoodsMode goodsMode = new GoodsMode();
        BeanUtils.copyProperties(goodsModeAddBO, goodsMode);
        Long time = TimeUtil.getCreateTime();
        goodsMode.setCreateTime(time);
        goodsMode.setUpdateTime(time);
        goodsMode.setDelFlag(TrueOrFalseEnum.FALSE_STAUTS.getStatus());

        boolean save = this.save(goodsMode);
        AssertException.isTrue(save, ErrorEnum.FAIL.getErrCode(), "新增失败");
        R<Boolean> booleanR = new R<>();
        booleanR.setData(save);
        return booleanR;
    }

    @Override
    @Transactional
    public R<Boolean> delGoodsMode(@RequestBody GoodsModeDelBO goodsModeDelBO) {
        AssertException.isNotBlank(goodsModeDelBO.getGoodsCode(), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品编码为空");
        AssertException.isNotNull(goodsModeDelBO.getId(), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品模式id为空");

        QueryWrapper<Goods> goodsQueryWrapper = new QueryWrapper<Goods>()
                .eq("goods_code", goodsModeDelBO.getGoodsCode());
        Goods goods = goodsService.getOne(goodsQueryWrapper);
        AssertException.isNotNull(goods, ErrorEnum.FAIL.getErrCode(), "商品不存在");

        //TODO 验证商品状态

        UpdateWrapper<GoodsMode> updateWrapper = new UpdateWrapper<GoodsMode>()
                .eq("goods_code", goodsModeDelBO.getGoodsCode())
                .eq("id", goodsModeDelBO.getId())
                .set("del_flag", TrueOrFalseEnum.TRUE_STAUTS.getFlag());
        boolean update = this.update(updateWrapper);
        AssertException.isTrue(update, ErrorEnum.FAIL.getErrCode(), "删除失败");

        R<Boolean> booleanR = new R<>();
        booleanR.setData(update);

        return booleanR;
    }

    @Override
    public R<Boolean> updateGoodsMode(@RequestBody GoodsModeUpdateBO goodsModeUpdateBO) {
        AssertException.isNotNull(goodsModeUpdateBO.getId(), ErrorEnum.VALIDATION_EOR.getErrCode(), "商品模式id为空");

        GoodsMode goodsMode = new GoodsMode();
        BeanUtils.copyProperties(goodsModeUpdateBO,goodsMode);

        UpdateWrapper<GoodsMode> goodsModeUpdateWrapper = new UpdateWrapper<>();
        goodsModeUpdateWrapper.eq("id",goodsModeUpdateBO.getId());

        boolean update = this.update(goodsModeUpdateWrapper);

        AssertException.isTrue(update, ErrorEnum.FAIL.getErrCode(), "更新失败");

        R<Boolean> booleanR = new R<>();
        booleanR.setData(update);
        return booleanR;
    }

    @Override
    public R<List<GoodsMode>> getByGoodsCode(@RequestParam("goodsCode") String goodsCode) {
        AssertException.isNotBlank(goodsCode, ErrorEnum.VALIDATION_EOR.getErrCode(), "商品编码为空");

        QueryWrapper<GoodsMode> goodsModeQueryWrapper = new QueryWrapper<GoodsMode>()
                .eq("goods_code",goodsCode)
                .eq("del_flag",TrueOrFalseEnum.FALSE_STAUTS.getFlag());
        List<GoodsMode> list = this.list(goodsModeQueryWrapper);

        R<List<GoodsMode>> r = new R<>();
        r.setData(list);
        return r;
    }
}
