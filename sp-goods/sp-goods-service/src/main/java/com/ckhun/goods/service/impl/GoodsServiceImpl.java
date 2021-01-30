package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.goods.mapper.GoodsMapper;
import com.ckhun.goods.pojo.Goods;
import com.ckhun.goods.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * create by one
 *
 * @Date 2021/1/30 16:54
 * @Description
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
