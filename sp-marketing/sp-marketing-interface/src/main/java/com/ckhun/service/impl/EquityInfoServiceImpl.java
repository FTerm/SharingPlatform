package com.ckhun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.mapper.EquityInfoMapper;
import com.ckhun.pojo.dto.EquityAddDTO;
import com.ckhun.pojo.dto.EquityDiscount;
import com.ckhun.pojo.dto.EquityEditDTO;
import com.ckhun.pojo.entity.EquityInfo;
import com.ckhun.pojo.vo.EquityInfoVo;
import com.ckhun.service.EquityInfoService;
import com.ckhun.utils.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 11:55 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Service
public class EquityInfoServiceImpl extends ServiceImpl<EquityInfoMapper, EquityInfo> implements EquityInfoService {

    @Override
    @Transactional
    public R<?> createEquity(EquityAddDTO equityAddDTO) {
        EquityInfo equityInfo = new EquityInfo();
        equityInfo.setEquityId(this.getRandomId());
        equityInfo.setDelFlag(TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        BeanUtils.copyProperties(equityAddDTO, equityInfo);
        if (equityAddDTO.getDiscountFlag().equals(TrueOrFalseEnum.TRUE_STAUTS.getStatus())) {
            EquityDiscount equityDiscount = equityAddDTO.getEquityDiscount();
            BeanUtils.copyProperties(equityDiscount, equityInfo);
        }
        boolean save = this.save(equityInfo);
        if (save) {
            return new R<>("权益卡：" + equityAddDTO.getName() + ", " + ErrorEnum.CREATE_SUCCESS.getErrMsg());
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return new R<>().fail(ErrorEnum.CREATE_EOR, null);
    }

    @Override
    public R<?> delEquity(String equityId) {
        QueryWrapper<EquityInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("equity_id", equityId);
        queryWrapper.eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        EquityInfo info = this.getOne(queryWrapper);
        if (info == null) {
            return new R<>().fail(ErrorEnum.DELETE_EOR, null);
        }
        UpdateWrapper<EquityInfo> wrapper = new UpdateWrapper<EquityInfo>()
                .eq("equity_id", equityId)
                .eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus())
                .set("del_flag", TrueOrFalseEnum.TRUE_STAUTS.getStatus());
        boolean update = this.update(wrapper);
        if (update) {
            return new R<>("权益卡：" + info.getName() + ", " + ErrorEnum.DELETE_SUCCESS.getErrMsg());
        }
        else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(ErrorEnum.DELETE_EOR, null);
        }
    }

    @Override
    @Transactional
    public R<?> modifyEquity(EquityEditDTO equityEditDTO) {
        String equityId = equityEditDTO.getEquityId();
        QueryWrapper<EquityInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("equity_id", equityId);
        queryWrapper.eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        EquityInfo info = this.getOne(queryWrapper);
        if (info == null) {
            return new R<>().fail(ErrorEnum.UPDATE_EOR, null);
        }
        UpdateWrapper<EquityInfo> updateWrapper = new UpdateWrapper<EquityInfo>()
                .eq("equity_id", equityId)
                .eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        if (equityEditDTO.getDiscountFlag().equals(TrueOrFalseEnum.FALSE_STAUTS.getStatus())) {
            updateWrapper.set("status", TrueOrFalseEnum.TRUE_STAUTS.getStatus());

        } else {
            updateWrapper.set("discount_flag", equityEditDTO.getDiscountFlag())
                    .set("discount", equityEditDTO.getEquityDiscount().getDiscount())
                    .set("discount_start_time", equityEditDTO.getEquityDiscount().getDiscountStartTime())
                    .set("discount_continuous_time", equityEditDTO.getEquityDiscount().getDiscountContinuousTime());

        }
        boolean update = this.update(updateWrapper);
        if (update) {
            return new R<>("权益卡：" + info.getName() + ", " + ErrorEnum.UPDATE_SUCCESS.getErrMsg());
        }
        else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(ErrorEnum.UPDATE_EOR, null);
        }
    }


    private String getRandomId() {
        return new Sha512Hash(System.currentTimeMillis() + ""+ "sha1EncodeEquity").toString();
    }

    @Override
    public PageResult findEquityByPage(PageRequest pageRequest) {
        return pageUtil.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<EquityInfoVo> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<EquityInfoVo> equityList = this.baseMapper.getEquityInfoList();
        return new PageInfo<EquityInfoVo>(equityList);
    }
}
