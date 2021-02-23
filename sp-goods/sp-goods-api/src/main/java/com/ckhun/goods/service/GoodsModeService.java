package com.ckhun.goods.service;

import com.ckhun.goods.bo.goodsmode.GoodsModeAddBO;
import com.ckhun.goods.bo.goodsmode.GoodsModeDelBO;
import com.ckhun.goods.bo.goodsmode.GoodsModeUpdateBO;
import com.ckhun.goods.pojo.GoodsMode;
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
public interface GoodsModeService {

    @PostMapping("addGoodsMode")
    public R<Boolean> addGoodsMode(@RequestBody GoodsModeAddBO goodsModeAddBO);

    @PostMapping("del")
    public R<Boolean> delGoodsMode(@RequestBody GoodsModeDelBO goodsModeDelBO);

    @PostMapping("updateInfo")
    public R<Boolean> updateGoodsMode(@RequestBody GoodsModeUpdateBO goodsModeUpdateBO);

    @GetMapping("getModeByGoodsCode")
    public R<List<GoodsMode>> getByGoodsCode(@RequestParam("goodsCode") String goodsCode);

}
