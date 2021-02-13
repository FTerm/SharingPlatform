package com.ckhun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.common.AssertException;
import com.ckhun.mapper.AdminMapper;
import com.ckhun.pojo.dto.AdminAddDTO;
import com.ckhun.pojo.dto.AdminLoginDTO;
import com.ckhun.pojo.entity.Admin;
import com.ckhun.pojo.vo.AdminProfileVo;
import com.ckhun.service.AdminService;
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
 * @date : Created in 14:33 2021/2/8
 * @description :
 * @since : 1.0.0
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    @Transactional
    public R<?> insertAdmin(AdminAddDTO adminAddDTO) {
        Admin admin = new Admin();
        String password = adminAddDTO.getPassword();
        String hash_password = this.getRandomPassword(password);
        adminAddDTO.setPassword(hash_password);
        BeanUtils.copyProperties(adminAddDTO, admin);
        admin.setStatus(TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<Admin>()
                .eq("status", TrueOrFalseEnum.FALSE_STAUTS.getStatus())
                .eq("user_name", adminAddDTO.getUserName());
        Admin queryAdmin = this.getOne(queryWrapper);
        if (queryAdmin != null) {
            return new R<>().fail(ErrorEnum.FAIL, null);
        }
        boolean save = this.save(admin);
        if (save) {
            return new R<>(adminAddDTO.getUserName() + " "+ ErrorEnum.CREATE_SUCCESS.getErrMsg());
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(ErrorEnum.CREATE_EOR, null);
        }

    }

    @Override
    @Deprecated
    @Transactional
    public R<?> updateAdmin() {
        return new R<>().fail(ErrorEnum.FAIL, null);
    }

    @Override
    public R<?> loginAdmin(AdminLoginDTO adminLoginDTO) {
        String encryptPassword = this.getRandomPassword(adminLoginDTO.getPassword());
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<Admin>()
                .eq("status", TrueOrFalseEnum.FALSE_STAUTS.getStatus())
                .eq("user_name", adminLoginDTO.getUserName());
        Admin admin = this.getOne(queryWrapper);
        if (admin == null) {
            return new R<>().fail(ErrorEnum.FAIL, null);
        }
//        AssertException.isNotNull(admin,ErrorEnum.FAIL.getErrCode(),"管理员不存在");
        boolean equals = admin.getPassword().equals(encryptPassword);
        if (equals) {
            return new R<>(ErrorEnum.LOGIN_SUCCESS.getErrMsg());
        } else {
            return new R<>().fail(ErrorEnum.EOR_LOGIN_PWD, null);
        }
    }

    @Override
    @Transactional
    public R<?> delAdmin(Integer id) {
        QueryWrapper<Admin> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("status", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        objectQueryWrapper.eq("id", id);
        Admin admin = this.getOne(objectQueryWrapper);
        if (admin == null) {
            return new R<>().fail(ErrorEnum.FAIL, null);
        }
//        AssertException.isNotNull(admin,ErrorEnum.FAIL.getErrCode(),"管理员不存在");
        UpdateWrapper<Admin> updateWrapper = new UpdateWrapper<Admin>()
                .eq("id", id)
                .set("status", TrueOrFalseEnum.TRUE_STAUTS.getStatus());
        boolean update = this.update(updateWrapper);
        if (update) {
            return new R<>("管理员： " + id + "" + ErrorEnum.DELETE_SUCCESS.getErrMsg());
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return new R<>().fail(ErrorEnum.DELETE_EOR, null);
    }

    @Override
    public PageResult selectAdminByPage(PageRequest pageRequest) {
        return pageUtil.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public R<?> profileAdmin(AdminLoginDTO adminLoginDTO) {
        AdminProfileVo adminProfileVo = new AdminProfileVo();
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<Admin>()
                .eq("user_name", adminLoginDTO.getUserName())
                .eq("status", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        Admin admin = this.getOne(queryWrapper);
        if (admin == null) {
            return new R<>().fail(ErrorEnum.FAIL, null);
        }
//        AssertException.isNotNull(admin,ErrorEnum.FAIL.getErrCode(),"管理员不存在");
        BeanUtils.copyProperties(admin, adminProfileVo);
        return new R<>(ErrorEnum.SUCCESS.getErrMsg(), adminProfileVo);
    }

    private String getRandomPassword(String s) {
        return new Sha512Hash("sha512Encode" + s).toString();
    }

    private PageInfo<AdminProfileVo> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<AdminProfileVo> adminList = this.baseMapper.getAdminList();
        return new PageInfo<AdminProfileVo>(adminList);
    }
}
