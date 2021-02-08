package SPuser.service;

import SPuser.sp_user_mapper.UserMapper;
import SPuser.sp_user_pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface UserServer {
        UserInfo selectUser(int id);

        List<UserInfo> selectUserAll();
    }
