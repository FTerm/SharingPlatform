package com.ckhun.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.goods.pojo.Classify;
import com.ckhun.goods.vo.classify.ClassifyListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/2/2 13:34
 * @Description
 */
@Mapper
public interface ClassifyMapper extends BaseMapper<Classify> {
    public List<ClassifyListVO> listClassify();
}
