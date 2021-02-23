package com.ckhun.goods.controller.back;

import com.ckhun.goods.bo.classify.ClassifyAddBO;
import com.ckhun.goods.dto.classify.ClassifyAddDTO;
import com.ckhun.goods.pojo.Classify;
import com.ckhun.goods.service.ClassifyService;
import com.ckhun.goods.vo.classify.ClassifyListVO;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/2/23 12:46
 * @Description
 */
@RestController
@RequestMapping("classify—back")
@Api(tags = "分类后台Api")
public class ClassifyBackController {

    @Autowired
    private ClassifyService classifyService;

    @GetMapping("list")
    @ApiOperation(value = "分类列表", httpMethod = "GET")
    public R<List<ClassifyListVO>> listInfo(){
        return classifyService.classifyList();
    }

    @PostMapping("add")
    @ApiOperation(value = "新增分类", httpMethod = "POST")
    public R<Boolean> add(@RequestBody ClassifyAddDTO classifyAddDTO){
        return classifyService.addClassify(classifyAddDTO);
    }

}
