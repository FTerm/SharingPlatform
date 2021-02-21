package com.ckhun.goods.vo.classify;

import com.ckhun.goods.pojo.Classify;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/2/8 22:25
 * @Description
 */
@Data
@ApiModel("分类-VO")
public class ClassifyListVO extends Classify {

    private List<Classify> children;

}
