package SPuser.service.icmp;

import SPuser.service.UserServer;
import SPuser.sp_user_mapper.UserMapper;
import SPuser.sp_user_pojo.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class UserServiceImpl implements UserServer {

    @Autowired
    UserMapper mapper;

    @Override
    public UserInfo selectUser(int id) {
        return mapper.selectUser(id);
    }

    @Override
    public List<UserInfo> selectUserAll() {
        return mapper.selectUserAll();
    }
}
