package com.qianfeng.market.service;

import com.qianfeng.market.pojo.dto.ResponseDTO;
import com.qianfeng.market.pojo.entity.ShopCar;
import com.qianfeng.market.pojo.vo.ShopCarVO;

import java.util.List;

/**
 * creator：Administrator
 * date:2019/12/18
 */
public interface ShopCarService {
    ResponseDTO edit(ShopCar shopCar);

    /**
     * 根据用户id寻找他的购物车的数量
     *
     * @param userId
     * @return
     */
    Integer getCarCountByUserId(Integer userId);

    /**
     * 根据用户查询购物车列表
     * @param userId
     * @return
     */
    List<ShopCarVO> findUserCars(Integer userId);
}
