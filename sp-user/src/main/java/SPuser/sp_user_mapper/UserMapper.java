package SPuser.sp_user_mapper;

import org.apache.ibatis.annotations.*;
import SPuser.sp_user_pojo.UserInfo;

import java.util.List;

/**
 * order:Junsen
 *
 * @Date 2021/1/31 21:07
 * @Description
 */
@Mapper
public interface UserMapper {


    /*******查询所有用户数据********/
    @Select("select * from user")
    List<UserInfo> selectUserAll();

    /*******根据id查询符合用户********/
    @Select("select * from user where id = #{id}")
    UserInfo selectUser(int id);


    /*******根据username查询符合用户********/
    @Select("SELECT * FROM test_login WHERE username=#{userName}")
    public UserInfo selectUserById(String username);

    /*******添加新用户********/
    @Insert("insert into user(name,age,phone) values (#{name},#{age},#{phone})")
    public int addUser(UserInfo user);


    /*******修改已有用户信息********/
    @Update("update user set username=#{username},password=#{password},age=#{age},birth=#{birth},phone=#{phone} where id=#{id}")
    public int updateUser(UserInfo user);

    @Update("update user set password=#{password} where id=#{id}")
    public int updateUserPassword(UserInfo user);

    @Update("update user set age=#{age} where id=#{id}")
    public int updateUserAge(UserInfo user);

    @Update("update user set phone=#{phone} where id=#{id}")
    public int updateUserPhone(UserInfo user);


    /*******根据id删除用户********/
    @Delete("delete from user where id=#{id}")
    public int deleteUser(int id);


}
