package com.ckhun.SPuser.service.impl;

import com.ckhun.SPuser.service.UserService;
import com.ckhun.SPuser.sp_user_mapper.UserMapper;
import com.ckhun.SPuser.sp_user_pojo.UserInfo;

import com.ckhun.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public UserInfo selectUser(int id) {
        return mapper.selectUser(id);
    }

    @Override
    public R<UserInfo> selectUserAll() {
        return mapper.selectUserAll();
    }

    public UserInfo selectUserById(int username){return mapper.selectUserById(username);}

    public R<UserInfo> insertUser(String username, String password,String email){
        return mapper.insertUser(username, password, email);
    }

    public R<UserInfo> updateUser(int id){return mapper.updateUser(id);}

    public R<UserInfo> updateUserPassword(Integer id){
        return mapper.updateUserPassword(id);
    }

    public R<UserInfo> updateUserAge(Integer id){
        return updateUserAge(id);
    }

    public R<UserInfo> updateUserPhone(Integer id){
        return updateUserPhone(id);
    }

    public R<UserInfo> deleteUser(Integer id){
        return deleteUser(id);
    }
}
