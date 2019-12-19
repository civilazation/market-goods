package com.qianfeng.market.service;

import com.qianfeng.market.pojo.dto.ResponseDTO;
import com.qianfeng.market.pojo.entity.Goods;
import com.qianfeng.market.pojo.entity.GoodsType;
import com.qianfeng.market.pojo.vo.GoodsTypeVO;

import java.util.List;

/**
 * creator：Administrator
 * date:2019/12/18
 */
public interface TypeService {
    /**
     * 增加商品类型
     *
     * @param goodsType
     * @return
     */
    ResponseDTO add(GoodsType goodsType);

    /**
     * 查询出所有一级商品类型给前端使用
     *
     * @return
     */
    List<GoodsTypeVO> selectTypesByParentId(int i);

}
