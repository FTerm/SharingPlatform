package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.common.AssertException;
import com.ckhun.goods.common.RedisUtilHand;
import com.ckhun.goods.dto.goodsarea.GoodsAreaItemListByPlaceDTO;
import com.ckhun.goods.mapper.GoodsAreaItemMapper;
import com.ckhun.goods.mapper.GoodsAreaMapper;
import com.ckhun.goods.pojo.GoodsArea;
import com.ckhun.goods.pojo.GoodsAreaItem;
import com.ckhun.goods.service.GoodsAreaItemService;
import com.ckhun.goods.service.GoodsAreaService;
import com.ckhun.utils.ErrorEnum;
import com.ckhun.utils.R;
import org.springframework.data.geo.GeoResults;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/2/20 19:01
 * @Description
 */
@RestController
public class GoodsAreaItemServiceImpl extends ServiceImpl<GoodsAreaItemMapper, GoodsAreaItem> implements GoodsAreaItemService {

}
