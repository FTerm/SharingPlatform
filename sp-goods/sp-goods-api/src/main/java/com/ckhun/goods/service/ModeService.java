package com.ckhun.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ckhun.goods.bo.mode.ModeAddBO;
import com.ckhun.goods.bo.mode.ModeDeleteBO;
import com.ckhun.goods.bo.mode.ModeUpdateBO;
import com.ckhun.goods.pojo.GoodsMode;
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
public interface ModeService {

    @PostMapping("add")
    public R<Boolean> addMode(@RequestBody ModeAddBO modeAddBO);

    @PostMapping("deleteMode")
    public R<Boolean> remove(@RequestBody ModeDeleteBO modeDeleteBO);

    @PostMapping("update")
    public R<Boolean> updateMode(@RequestBody ModeUpdateBO modeUpdateBO);

    @GetMapping("byId")
    public R<Mode> getModeById(@RequestParam("id") Integer id);

    @GetMapping("list")
    public R<List<Mode>> listMode();
}
