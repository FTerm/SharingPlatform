package com.ckhun.goods.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * create by one
 *
 * @Date 2021/2/20 19:06
 * @Description
 */
public class RedisUtilHand {

    @Autowired
    private static RedisTemplate redisTemplate;

    public static Long geoAdd(String key, String lo, String la, String n){
        Long addedNum = redisTemplate.opsForGeo().add(key, new Point(Double.valueOf(lo), Double.valueOf(la)), n);//params: key, Point(经度, 纬度), 地方名称
        return addedNum;
    }

    public static GeoResults geoRadius(String key,String lo, String la,Integer value){
        Circle circle = new Circle(new Point(Double.valueOf(lo),Double.valueOf(la)),new Distance(1500, Metrics.MILES));
        GeoResults radius = redisTemplate.opsForGeo().radius(key, circle);
        return radius;
    }


}
