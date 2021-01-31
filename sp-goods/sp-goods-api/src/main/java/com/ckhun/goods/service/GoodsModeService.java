package com.ckhun.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ckhun.goods.pojo.GoodsItem;
import com.ckhun.goods.pojo.GoodsMode;
import com.ckhun.goods.pojo.Mode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/1/30 16:50
 * @Description
 */
@FeignClient(name = "sp-goods")
public interface GoodsModeService {

}
