package com.ckhun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckhun.pojo.entity.EquityInfo;
import com.ckhun.pojo.vo.EquityInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Kunhong Chan
 * @date : Created in 11:48 2021/2/19
 * @description :
 * @since : 1.0.0
 */
@Mapper
public interface EquityInfoMapper extends BaseMapper<EquityInfo> {

    @Select("SELECT\n" +
            "   m_equity_info.id, \n" +
            "	m_equity_info.equity_id, \n" +
            "	m_equity_info.`name`, \n" +
            "	m_equity_info.description, \n" +
            "	m_equity_info.frequency_flag, \n" +
            "	m_equity_info.continuous, \n" +
            "	m_equity_info.`status`, \n" +
            "	m_equity_info.price, \n" +
            "	m_equity_info.discount_flag, \n" +
            "	m_equity_info.discount, \n" +
            "	m_equity_info.discount_start_time, \n" +
            "	m_equity_info.discount_continuous_time, \n" +
            "	m_equity_info.new_flag, \n" +
            "	m_equity_info.new_continuous_time, \n" +
            "	m_equity_info.recommend, \n" +
            "	m_equity_info.special_product\n" +
            "FROM\n" +
            "	m_equity_info\n" +
            "WHERE\n" +
            "	m_equity_info.del_flag = 1")
    List<EquityInfoVo> getEquityInfoList();
}
