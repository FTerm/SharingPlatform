package com.ckhun.goods.service;

import com.ckhun.goods.bo.mode.ModeAddBO;
import com.ckhun.goods.bo.mode.ModeDeleteBO;
import com.ckhun.goods.bo.mode.ModeUpdateBO;
import com.ckhun.goods.pojo.Mode;
import com.ckhun.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * create by one
 *
 * @Date 2021/1/30 16:50
 * @Description
 */
@FeignClient(name = "sp-goods")
@RestController("mode-api")
public interface ModeService {

    @PostMapping("addMode")
    public R<Boolean> addMode(@RequestBody ModeAddBO modeAddBO);

    @PostMapping("deleteMode")
    public R<Boolean> remove(@RequestBody ModeDeleteBO modeDeleteBO);

    @PostMapping("updateMode")
    public R<Boolean> updateMode(@RequestBody ModeUpdateBO modeUpdateBO);

    @GetMapping("getByModeId")
    public R<Mode> getModeById(@RequestParam("id") Integer id);

    @GetMapping("listMode")
    public R<List<Mode>> listMode();

}
