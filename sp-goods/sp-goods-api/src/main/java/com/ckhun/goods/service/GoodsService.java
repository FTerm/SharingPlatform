package com.ckhun.goods.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/1/30 16:50
 * @Description
 */
@RestController("goods-api")
@FeignClient("goods-service")
public interface GoodsService {

}
