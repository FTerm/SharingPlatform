package com.ckhun.goods.service;

import com.ckhun.goods.dto.goodsarea.GoodsAreaItemListByPlaceDTO;
import com.ckhun.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * create by one
 *
 * @Date 2021/2/2 13:56
 * @Description
 */
@FeignClient(name = "sp-goods")
public interface GoodsAreaItemService {

}
