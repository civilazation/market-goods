package com.qianfeng.market.pojo.vo;

import com.qianfeng.market.pojo.entity.Goods;
import com.qianfeng.market.pojo.entity.ShopCar;
import lombok.Data;

/**
 * creator：Administrator
 * date:2019/12/18
 */
@Data
public class ShopCarVO extends ShopCar {
    /**
     * 这个购物车对应的商品
     */
    private Goods goods;


}
