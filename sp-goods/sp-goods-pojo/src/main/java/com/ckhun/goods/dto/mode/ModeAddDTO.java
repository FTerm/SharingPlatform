package com.ckhun.goods.dto.mode;

import com.ckhun.goods.bo.mode.ModeAddBO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * create by one
 *
 * @Date 2021/2/1 14:10
 * @Description
 */
@Data
@ApiModel("模式新增DTO")
public class ModeAddDTO extends ModeAddBO implements Serializable {
}
