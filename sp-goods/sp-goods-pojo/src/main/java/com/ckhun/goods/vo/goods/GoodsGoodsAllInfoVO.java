package com.ckhun.goods.vo.goods;

import com.ckhun.goods.pojo.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * create by one
 *
 * @Date 2021/2/23 15:08
 * @Description
 */
@Data
public class GoodsGoodsAllInfoVO implements Serializable {

    private Goods goods;

    private GoodsItem goodsItem;

    private List<GoodsMode> goodsMode;    //商品所支持模式

    private List<Mode> mode;  //模式

    private GoodsAreaItem goodsAreaItem;    //所在的区域

    private GoodsArea goodsArea;    //区域
}
