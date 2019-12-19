package com.qianfeng.market.service.impl;

import com.qianfeng.market.dao.GoodsTypeDao;
import com.qianfeng.market.pojo.dto.ResponseDTO;
import com.qianfeng.market.pojo.entity.GoodsType;
import com.qianfeng.market.pojo.vo.GoodsTypeVO;
import com.qianfeng.market.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * creator：Administrator
 * date:2019/12/18
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    GoodsTypeDao goodsTypeDao;

    @Override
    public ResponseDTO add(GoodsType goodsType) {
        if (goodsTypeDao.insert(goodsType) == 1) {// 表示增加成功
            return ResponseDTO.ok("增加商品类型成功");

        } else {
            return ResponseDTO.fail("增加商品类型失败");

        }
    }

    @Override
    public List<GoodsTypeVO> selectTypesByParentId(int i) {
        List<GoodsTypeVO> parentTypes = goodsTypeDao.selectTypesByParentId(i);
//        for (GoodsTypeVO g : parentTypes) {// for循环里边调用查询语句，非常影响性能
//            List<GoodsTypeVO> childrenTypes = goodsTypeDao.selectTypesByParentId(g.getGoodsTypeId());
//            g.setChildrenTypes(childrenTypes);
//        }
        List<GoodsTypeVO> childrenTypes = goodsTypeDao.selectTypesByParentIds(parentTypes);
        Map<Integer, List<GoodsTypeVO>> collect = childrenTypes.stream().collect(Collectors.groupingBy(GoodsTypeVO::getParentTypeId));
        for (GoodsTypeVO g : parentTypes) {// for循环里边调用查询语句，非常影响性能
            List<GoodsTypeVO> childrenTypes1 = collect.get(g.getGoodsTypeId());
            g.setChildrenTypes(childrenTypes1);
        }
        return parentTypes;
    }


}
