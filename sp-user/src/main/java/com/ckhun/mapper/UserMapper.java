package com.ckhun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.pojo.entity.User;
import com.ckhun.pojo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 18:16 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT\n" +
            "	c_user.id, \n" +
            "	c_user.username, \n" +
            "	c_user.gender, \n" +
            "	c_user.email, \n" +
            "	c_user.phone, \n" +
            "	c_user.`status`, \n" +
            "	c_user.create_time, \n" +
            "	c_user.update_time\n" +
            "FROM\n" +
            "	c_user\n" +
            "WHERE\n" +
            "	c_user.del_flag = 0")
    List<UserVo> getUserList();
}
