package com.ckhun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.pojo.entity.Admin;
import com.ckhun.pojo.vo.AdminProfileVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 14:34 2021/2/8
 * @description :
 * @since : 1.0.0
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    @Select("select id, user_name, login_ip, last_login_time, create_time, update_time from p_admin where status = 0")
    List<AdminProfileVo> getAdminList();
}
