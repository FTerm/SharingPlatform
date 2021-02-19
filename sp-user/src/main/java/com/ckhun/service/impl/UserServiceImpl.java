package com.ckhun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.mapper.UserMapper;
import com.ckhun.pojo.dto.UserAddDTO;
import com.ckhun.pojo.dto.UserChangePassword;
import com.ckhun.pojo.dto.UserDTO;
import com.ckhun.pojo.dto.UserEditDTO;
import com.ckhun.pojo.entity.User;
import com.ckhun.pojo.vo.UserVo;
import com.ckhun.service.UserService;
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
 * @date : Created in 18:18 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @Transactional
    public R<?> userAdd(UserAddDTO userAddDTO) {
        User user = new User();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
                .eq("username", userAddDTO.getUsername())
                .eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        User user1 = this.getOne(userQueryWrapper);
        if (user1 != null) {
            return new R<>().fail(ErrorEnum.CREATE_EOR, null);
        }
        String randomPassword = getRandomPassword(userAddDTO.getPassword());
        userAddDTO.setPassword(randomPassword);
        BeanUtils.copyProperties(userAddDTO, user);
        user.setStatus(TrueOrFalseEnum.TRUE_STAUTS.getStatus());
        user.setDelFlag(TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        boolean save = this.save(user);
        if (save) {
            return new R<>("用户： " + user.getUsername() + ", " + ErrorEnum.CREATE_SUCCESS.getErrMsg());
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(ErrorEnum.CREATE_EOR, null);
        }
    }

    @Override
    @Transactional
    public R<?> changePassword(UserChangePassword userChangePassword) {
        QueryWrapper<User> q = new QueryWrapper<User>();
        q.eq("username", userChangePassword.getUsername());
        q.eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        User user = this.getOne(q);
        if (user == null) {
            return new R<>().fail(ErrorEnum.EOR_USER_NOT_FOUND, null);
        }
        String oldPassword = this.getRandomPassword(userChangePassword.getPassword());

        if (!user.getPassword().equals(oldPassword)) {
            return new R<>().fail(ErrorEnum.EX_NOT_MATCH_PWD, null);
        }
        String newPassword = this.getRandomPassword(userChangePassword.getChangePassword());
        if (user.getPassword().equals(newPassword)) {
            return new R<>().fail(ErrorEnum.EX_NOT_DIFF_PASSWORD, null);
        }
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("username", userChangePassword.getUsername());
        userUpdateWrapper.eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        userUpdateWrapper.set("password", newPassword);
        boolean update = this.update(userUpdateWrapper);
        if (update) {
            return new R<>(ErrorEnum.UPDATE_SUCCESS.getErrMsg());
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(ErrorEnum.UPDATE_EOR, null);
        }
    }

    @Override
    @Transactional
    public R<?> userModify(UserEditDTO userEditDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .eq("username", userEditDTO.getUsername())
                .eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        User user = this.getOne(queryWrapper);
        if (user == null) {
            return new R<>().fail(ErrorEnum.UPDATE_EOR, null);
        }
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>()
                .eq("username", userEditDTO.getUsername())
                .eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        if (userEditDTO.getPassword() != null) {
            if (this.getRandomPassword(userEditDTO.getPassword()).equals(user.getPassword())) {
                return new R<>().fail(ErrorEnum.EOR_LOGIN_PWD, null);
            }
        }
        if (userEditDTO.getEmail() != null) {
            updateWrapper.set("email", userEditDTO.getEmail());
        }
        if (userEditDTO.getPhone() != null) {
            updateWrapper.set("phone", userEditDTO.getPhone());
        }
        boolean update = this.update(updateWrapper);
        if (update) {
            return new R<>(ErrorEnum.UPDATE_SUCCESS.getErrMsg());
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new R<>().fail(ErrorEnum.UPDATE_EOR, null);
        }
    }

    @Override
    public R<?> profileUser(UserDTO userDTO) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
                .eq("username", userDTO.getUsername())
                .eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        User user = this.getOne(userQueryWrapper);
        UserVo userVo = new UserVo();
        if (user == null) {
            return new R<>().fail(ErrorEnum.EOR_USER_NOT_FOUND, null);
        }
        BeanUtils.copyProperties(user, userVo);
        return new R<>(ErrorEnum.HTTP_SUCCESS.getErrMsg(), userVo);
    }

    @Override
    public PageResult getUserByPage(PageRequest pageRequest) {
        return pageUtil.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public R<?> userLogin(UserDTO userDTO) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
                .eq("username", userDTO.getUsername())
                .eq("del_flag", TrueOrFalseEnum.FALSE_STAUTS.getStatus());
        User user = this.getOne(userQueryWrapper);
        if (user == null) {
            return new R<>().fail(ErrorEnum.EOR_USER_NOT_FOUND, null);
        }
        if (user.getStatus().equals(TrueOrFalseEnum.FALSE_STAUTS.getStatus())) {
            return new R<>().fail(ErrorEnum.EOR_LOGIN_USER_BAN, null);
        }
        if (this.getRandomPassword(userDTO.getPassword()).equals(user.getPassword())) {
            return new R<>(ErrorEnum.LOGIN_SUCCESS.getErrMsg());
        }
        return new R<>().fail(ErrorEnum.EOR_LOGIN_PWD, null);
    }

    @Deprecated
    @Override
    public R<?> addBalance() {
        return null;
    }

    private String getRandomPassword(String s) {
        return new Sha512Hash("sha512EncodeUser" + s).toString();
    }

    private PageInfo<UserVo> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<UserVo> userList = this.baseMapper.getUserList();
        return new PageInfo<UserVo>(userList);
    }


}
