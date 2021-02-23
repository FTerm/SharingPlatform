package com.ckhun.goods.controller.back;

import com.ckhun.goods.dto.mode.ModeAddDTO;
import com.ckhun.goods.dto.mode.ModeDeleteDTO;
import com.ckhun.goods.dto.mode.ModeUpdateDTO;
import com.ckhun.goods.service.ModeService;
import com.ckhun.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/2/23 12:59
 * @Description
 */
@RestController
@RequestMapping("mode—back")
@Api(tags = "模式相关后台Api")
public class ModeBackController {
    @Autowired
    private ModeService modeService;

    @PostMapping("addMode")
    @ApiOperation(value = "新增模式",httpMethod = "POST")
    public R<Boolean> addMode(@RequestBody ModeAddDTO modeAddDTO){
        R<Boolean> booleanR = modeService.addMode(modeAddDTO);
        return booleanR;
    }

    @PostMapping("deleteMode")
    @ApiOperation(value = "删除模式",httpMethod = "POST")
    public R<Boolean> remove(@RequestBody ModeDeleteDTO modeDeleteDTO){
        R<Boolean> remove = modeService.remove(modeDeleteDTO);
        return remove;
    }

    @PostMapping("updateMode")
    @ApiOperation(value = "更新模式",httpMethod = "POST")
    public R<Boolean> updateMode(@RequestBody ModeUpdateDTO modeUpdateDTO){
        R<Boolean> booleanR = modeService.updateMode(modeUpdateDTO);
        return booleanR;
    }
}
