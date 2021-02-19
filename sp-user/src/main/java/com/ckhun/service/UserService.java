package com.ckhun.service;

import com.ckhun.pojo.dto.UserAddDTO;
import com.ckhun.pojo.dto.UserChangePassword;
import com.ckhun.pojo.dto.UserDTO;
import com.ckhun.pojo.dto.UserEditDTO;
import com.ckhun.utils.PageRequest;
import com.ckhun.utils.PageResult;
import com.ckhun.utils.R;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:18 2021/2/19
 * @description :
 * @since : 1.0.0
 */
public interface UserService {

    R<?> userAdd(UserAddDTO userAddDTO);

    R<?> userModify(UserEditDTO userEditDTO);

    R<?> profileUser(UserDTO userDTO);

    PageResult getUserByPage(PageRequest pageRequest);

    R<?> userLogin(UserDTO userDTO);

    R<?> changePassword(UserChangePassword userChangePassword);

    @Deprecated
    R<?> addBalance();


}
