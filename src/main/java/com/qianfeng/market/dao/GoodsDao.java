package com.qianfeng.market.dao;

import com.qianfeng.market.pojo.entity.Goods;
import com.qianfeng.market.pojo.vo.ShopCarVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> getGoodsByTypeId(Integer typeId);

    List<Goods> selectGoodsByIds(@Param("ids") List carVOS);
}
