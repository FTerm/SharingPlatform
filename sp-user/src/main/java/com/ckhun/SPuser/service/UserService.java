package com.ckhun.SPuser.service;

import com.ckhun.SPuser.sp_user_pojo.UserInfo;
import com.ckhun.utils.R;

public interface UserService {
        UserInfo selectUser(int id);

        R<UserInfo> selectUserAll();

        UserInfo selectUserById(int username);

        R<UserInfo> insertUser(String username, String password,String email);

        R<UserInfo> updateUser(int id);

        R<UserInfo> updateUserPassword(Integer id);

        R<UserInfo> updateUserAge(Integer id);

        R<UserInfo> updateUserPhone(Integer id);

        R<UserInfo> deleteUser(Integer id);
}
