package sp_user.sp_user_controller;

import SPuser.service.ResultModel;
import SPuser.service.ResultTools;
import SPuser.service.UserServer;
import SPuser.sp_user_mapper.UserMapper;
import SPuser.sp_user_pojo.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * order:Junsen
 *
 * @Date 2021/1/31 21:08
 * @Description
 */
@RestController
@RequestMapping("/select")
public class UserController {

    private UserServer userServer;
    //Select By Id
    @RequestMapping("/selectUser/{id}")
    public String selectTeacher(@PathVariable int id){
        return userServer.selectUser(id).toString();
    }

    //Select All
    @RequestMapping("/selectUserAll")
    public String selectAll() {
        return userServer.selectUserAll().toString();
    }
}
