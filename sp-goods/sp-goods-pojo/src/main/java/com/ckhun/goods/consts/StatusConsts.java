package com.ckhun.goods.consts;

/**
 * create by one
 *
 * @Date 2021/2/7 21:57
 * @Description
 */
public interface StatusConsts {

    public final static Integer WAIT_STATUS = 0;  //新增，商品处于等待状态

    public final static Integer NORMARL_STATUS = 1;   //正常

    public final static Integer DELETE_STATUS = -1;   //删除

    public final static Integer WORKING_STATUS = 7; //运行中，商品处于租借状态

    public final static Integer FAULT_STATUS = -2;  //商品故障


}
