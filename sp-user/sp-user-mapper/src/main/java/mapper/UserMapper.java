package mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.UserInfo;

import java.util.List;

/**
 * order:Junsen
 *
 * @Date 2021/1/31 21:07
 * @Description
 */

public interface UserMapper {

    /*******查询所有用户数据********/
    @Select("select * from user")
    public List<UserInfo> selectUserByAll();

    /*******根据id查询符合用户********/
    @Select("select * from user where id = #{id}")
    public UserInfo selectUserById(int id);

    /*******根据name查询符合用户********/
    @Select("select * from user where name=#{name}")
    public List<UserInfo> selectUserByName(String name);

    /*******添加新用户********/
    @Insert("insert into user(name,age,phone) values (#{name},#{age},#{phone})")
    public int addUser(UserInfo user);

    /*******修改已有用户信息********/
    @Update("update user set name=#{name},age=#{age},phone=#{phone} where id=#{id}")
    public int updateUser(UserInfo user);

    /*******根据id删除用户********/
    @Delete("delete from user where id=#{id}")
    public int deleteUser(int id);

}
