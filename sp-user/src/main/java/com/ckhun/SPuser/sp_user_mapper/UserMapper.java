package com.ckhun.SPuser.sp_user_mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.utils.R;
import org.apache.ibatis.annotations.*;
import com.ckhun.SPuser.sp_user_pojo.UserInfo;

import java.util.List;

/**
 * order:Junsen
 *
 * @Date 2021/1/31 21:07
 * @Description
 */
@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {


    /*******查询所有用户数据********/
    @Select("select * from c_user")
    R<UserInfo> selectUserAll();

    /*******根据id查询符合用户********/
    @Select("select * from c_user where id = #{id}")
    UserInfo selectUser(int id);


    /*******根据username查询符合用户********/
    @Select("SELECT * FROM test_login WHERE username=#{userName}")
    UserInfo selectUserById(String username);

    /*******添加新用户********/
    @Insert("insert into c_user(username,password,phone) values (#{name},#{password},#{phone})")
    R<UserInfo> insertUser(String username, String password,String email);


    /*******修改已有用户信息********/
    @Update("update c_user set username=#{username},password=#{password},age=#{age},birth=#{birth},phone=#{phone} where id=#{id}")
    R<UserInfo> updateUser(UserInfo id);

    @Update("update c_user set password=#{password} where id=#{id}")
    R<UserInfo> updateUserPassword(Integer id);

    @Update("update c_user set age=#{age} where id=#{id}")
    R<UserInfo> updateUserAge(Integer id);

    @Update("update c_user set phone=#{phone} where id=#{id}")
    R<UserInfo> updateUserPhone(Integer id);


    /*******根据id删除用户********/
    @Delete("delete from c_user where id=#{id}")
    R<UserInfo> deleteUser(Integer id);


}
