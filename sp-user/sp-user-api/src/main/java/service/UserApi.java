package service;



import com.ckhun.utils.R;
import pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * order:Junsen
 *
 * @Date 2021/1/31 21:09
 * @Description
 */

@FeignClient(name = "sp-user")
public interface UserApi {

    /**
     * 添加用户
     * @param UserInfo
     * @return
     */
    @PostMapping("addUser")
    public R<String> add(@RequestBody UserInfo UserInfo);

    /**
     * 更新用户信息
     *
     * @param UserInfo
     * @return
     */
    @PostMapping("updateUser")
    public R<Boolean> update(@RequestBody UserInfo UserInfo);

    /**
     * 通过id获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("byGoodsCode")
    public R<UserInfo> goodsByCode(@RequestParam("id") String id);
}
