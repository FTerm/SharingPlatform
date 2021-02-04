package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.common.AssertException;
import com.ckhun.goods.bo.classify.ClassifyAddBO;
import com.ckhun.goods.bo.classify.ClassifyDelBO;
import com.ckhun.goods.bo.classify.ClassifyUpdateBO;
import com.ckhun.goods.mapper.ClassifyMapper;
import com.ckhun.goods.pojo.Classify;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.service.ClassifyService;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.R;
import com.ckhun.utils.TimeUtil;
import com.ckhun.utils.TrueOrFalseEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/2/2 14:17
 * @Description
 */
@RestController
@RequestMapping("classifyApi")
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {

    @Autowired
    private GoodsServiceImpl goodsService;

    @Override
    public R<Boolean> addClassify(@RequestBody ClassifyAddBO classifyAddBO) {
        AssertException.isNotBlank(classifyAddBO.getClassifyName(), ErrorEnum.VALIDATION_EOR.getErrCode(),"分类名称为空");
        AssertException.isNotNull(classifyAddBO.getStatus(),ErrorEnum.VALIDATION_EOR.getErrCode(),"状态为空");

        if (classifyAddBO.getType()!=1){
            AssertException.isNotNull(classifyAddBO.getPid(),ErrorEnum.VALIDATION_EOR.getErrCode(),"二级以上分类需要指定pid");
            //验证分类
            Classify classifyByPid = this.getById(classifyAddBO.getPid());
            AssertException.isTrue(classifyAddBO.getType()>classifyByPid.getType(),ErrorEnum.VALIDATION_EOR.getErrCode(),"分类类型越界");
        }else{
            classifyAddBO.setPid(0);    //一级分类
        }

        Classify classify = new Classify();
        BeanUtils.copyProperties(classifyAddBO,classify);
        Long createTime = TimeUtil.getCreateTime();
        classify.setDelFlag(TrueOrFalseEnum.FALSE_STAUTS.getStatus());  //为逻辑删除
        classify.setCreateTime(createTime);
        classify.setUpdateTime(createTime);

        boolean save = this.save(classify);

        AssertException.isTrue(save,ErrorEnum.FAIL.getErrCode(),"新增失败");
        R<Boolean> r = new R<>();
        r.setData(save);
        return r;
    }

    @Override
    public R<Boolean> delClassify(@RequestBody ClassifyDelBO classifyDelBO) {
        AssertException.isNotNull(classifyDelBO.getId(),ErrorEnum.VALIDATION_EOR.getErrCode(),"id为空");

        /**
         * 验证商品是否依赖分类
         */
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<Goods>().eq("type",classifyDelBO.getId());
        List<Goods> list = goodsService.list(queryWrapper);
        AssertException.isTrue(list.size()==0,ErrorEnum.FAIL.getErrCode(),"存在商品依赖该分类");

        //验证是否有子分类依赖
        QueryWrapper<Classify> classifyQueryWrapper = new QueryWrapper<>();
        classifyQueryWrapper.eq("pid",classifyDelBO.getId());
        List<Classify> classifyList = this.list(classifyQueryWrapper);
        AssertException.isTrue(list.size()==0,ErrorEnum.FAIL.getErrCode(),"存在子分类依赖该分类");

        boolean b = this.removeById(classifyDelBO.getId());

        AssertException.isTrue(b,ErrorEnum.FAIL.getErrCode(),"删除失败");
        R<Boolean> r = new R<>();
        r.setData(b);

        return r;
    }

    @Override
    public R<Boolean> updateClassify(@RequestBody ClassifyUpdateBO classifyUpdateBO) {

        return null;
    }

    @Override
    public R<List<Classify>> listPage() {
        return null;
    }
}
