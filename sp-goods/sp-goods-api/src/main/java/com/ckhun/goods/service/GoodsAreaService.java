package com.ckhun.goods.service;

import com.ckhun.goods.dto.goodsarea.GoodsAreaItemListByPlaceDTO;
import com.ckhun.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/2/2 13:56
 * @Description
 */
@FeignClient(name = "sp-goods")
@RestController("goods-area-api")
public interface GoodsAreaService {

    @PostMapping("singleArea")
    public R addSingleArea();

    @PostMapping("listInfoByPlace")
    public R listInfo(@RequestBody GoodsAreaItemListByPlaceDTO goodsAreaItemListByPlaceDTO);


}
