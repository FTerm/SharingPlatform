package com.ckhun.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ckhun.common.AssertException;
import com.ckhun.goods.common.RedisUtilHand;
import com.ckhun.goods.dto.goodsarea.GoodsAreaItemListByPlaceDTO;
import com.ckhun.goods.mapper.GoodsAreaMapper;
import com.ckhun.goods.pojo.GoodsArea;
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
public class GoodsAreaServiceImpl extends ServiceImpl<GoodsAreaMapper, GoodsArea> implements GoodsAreaService {

    private final static String KEY_NAME = "AREA_";

    @Override
    public R addSingleArea() {
        return null;
    }

    /**
     * 通过经纬度和类型查找1.5km内的区域
     *
     * @param goodsAreaItemListByPlaceDTO
     * @return
     */
    @Override
    public R listInfo(@RequestBody GoodsAreaItemListByPlaceDTO goodsAreaItemListByPlaceDTO) {
        AssertException.isNotBlank(goodsAreaItemListByPlaceDTO.getLatitude(), ErrorEnum.VALIDATION_EOR.getErrCode(), "纬度为空");
        AssertException.isNotBlank(goodsAreaItemListByPlaceDTO.getLongitude(), ErrorEnum.VALIDATION_EOR.getErrCode(), "经度为空");
        AssertException.isNotNull(goodsAreaItemListByPlaceDTO.getType(), ErrorEnum.VALIDATION_EOR.getErrCode(), "类型为空");

        if (goodsAreaItemListByPlaceDTO.getType()!=null) {
            String key = KEY_NAME+goodsAreaItemListByPlaceDTO.getType();

            GeoResults geoResults = RedisUtilHand.geoRadius(key, goodsAreaItemListByPlaceDTO.getLongitude(), goodsAreaItemListByPlaceDTO.getLatitude(), 1500);

        }
        return null;
    }
}
