package com.ckhun.goods.dto.mode;

import com.ckhun.goods.bo.mode.ModeDeleteBO;
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
@ApiModel("模式删除DTO")
public class ModeDeleteDTO extends ModeDeleteBO implements Serializable {
}
