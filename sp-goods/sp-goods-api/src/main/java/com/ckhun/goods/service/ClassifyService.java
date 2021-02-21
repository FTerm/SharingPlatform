package com.ckhun.goods.service;

import com.ckhun.goods.bo.classify.ClassifyAddBO;
import com.ckhun.goods.bo.classify.ClassifyDelBO;
import com.ckhun.goods.bo.classify.ClassifyUpdateBO;
import com.ckhun.goods.vo.classify.ClassifyListVO;
import com.ckhun.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/2/2 13:56
 * @Description
 */
@FeignClient(name = "sp-goods")
@RestController("classify-service")
public interface ClassifyService {

    @PostMapping("addClassify")
    public R<Boolean> addClassify(@RequestBody ClassifyAddBO classifyAddBO);

    @PostMapping("deleteClassify")
    public R<Boolean> delClassify(@RequestBody ClassifyDelBO classifyDelBO);

    @PostMapping("updateClassify")
    public R<Boolean> updateClassify(@RequestBody ClassifyUpdateBO classifyUpdateBO);

    @GetMapping("listInfo")
    public R<List<ClassifyListVO>> listClassify();
}
