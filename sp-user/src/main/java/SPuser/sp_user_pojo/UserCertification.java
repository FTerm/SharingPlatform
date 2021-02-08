package SPuser.sp_user_pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("c_user_certification")
public class UserCertification implements Serializable {

    @TableField("id")
    private Integer id;
    @TableField("uid")
    private Integer uid;
    @TableField("id_card")
    private String id_card;
    @TableField("true_name")
    private String true_name;

    @TableField("id_card_front")
    private String id_card_front;

    @TableField("id_card_back")
    private String id_card_back;

    @TableField("create_time")
    private Long create_time;

    @TableField("update_time")
    private Long update_time;

    @TableField("status")
    private Integer status;

}
