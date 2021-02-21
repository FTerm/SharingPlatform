package com.ckhun.goods.controller;

import com.ckhun.goods.service.ClassifyService;
import com.ckhun.goods.vo.classify.ClassifyListVO;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/2/8 23:02
 * @Description
 */
@RestController
@RequestMapping("classify")
@Api("分类Api")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;
    @GetMapping("list")
    public R<List<ClassifyListVO>> listInfo(){
        return classifyService.listClassify();
    }
}
