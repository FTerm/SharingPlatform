package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.goods.mapper.GoodsMapper;
import com.ckhun.goods.mapper.GoodsModeMapper;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.pojo.GoodsMode;
import com.ckhun.goods.service.GoodsModeService;
import com.ckhun.goods.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by one
 *
 * @Date 2021/1/30 16:54
 * @Description
 */
@RestController
public class GoodsModeServiceImpl extends ServiceImpl<GoodsModeMapper, GoodsMode> implements GoodsModeService {
}
