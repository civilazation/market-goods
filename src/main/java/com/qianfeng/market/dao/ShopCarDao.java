package com.qianfeng.market.dao;

import com.qianfeng.market.pojo.entity.ShopCar;
import com.qianfeng.market.pojo.vo.ShopCarVO;

import java.util.List;

public interface ShopCarDao {
    int deleteByPrimaryKey(Integer shopCarId);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(Integer shopCarId);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);

    /**
     * 根据用户id和商品id查找购物车
     * @param shopCar
     * @return
     */
    ShopCar findCarByUserIdAndGoods(ShopCar shopCar);

    Integer selectCarCountByUserId(Integer userId);

    /**
     * 根据用户id查询其购物车
     * @param userId
     * @return
     */
    List<ShopCarVO> findUserCars(Integer userId);
}
