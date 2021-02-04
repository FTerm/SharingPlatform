package com.ckhun.goods.bo.goodsmode;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * create by one
 *
 * @Date 2021/2/1 13:08
 * @Description
 */
@Data
@ApiModel("新增-商品模式")
public class GoodsModeAddBO {

    @ApiModelProperty("商品编码")
    private String goodsCode;

    @ApiModelProperty("商品模式id")
    private Integer modeId;

    @ApiModelProperty("价钱")
    private Long price;

    @ApiModelProperty("期望价钱")
    private Long target;

    @ApiModelProperty("状态")
    private Integer status;

}
