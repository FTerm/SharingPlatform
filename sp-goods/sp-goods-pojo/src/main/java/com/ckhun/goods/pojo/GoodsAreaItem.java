package com.ckhun.goods.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * create by one
 *
 * @Date 2021/2/8 21:19
 * @Description
 */
@Data
@TableName("g_goods_area_item")
@ApiModel(description = "商品区域实体项目",value = "商品区域实体项目")
public class GoodsAreaItem {

    private String areaCode;

    private String sku;

    private Date createTime;

    private Date updateTime;

    private Integer status;
}
