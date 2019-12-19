package com.qianfeng.market.dao;

import com.qianfeng.market.pojo.entity.OrderInfo;

public interface OrderInfoDao {
    int deleteByPrimaryKey(Integer orderInfoId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer orderInfoId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}