package com.qianfeng.market.service;

import com.qianfeng.market.pojo.dto.ResponseDTO;
import com.qianfeng.market.pojo.entity.UserOrder;
import com.qianfeng.market.pojo.vo.ShopCarVO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * creator：Administrator
 * date:2019/12/19
 */
public interface OrderService {

    @Transactional(propagation = Propagation.REQUIRED)
        // 开启事务控制
    ResponseDTO addOrder(UserOrder userOrder, List<ShopCarVO> carVOS);

    UserOrder getOrderDetailByOrderId(String orderId);

    /**
     * 更新付款状态
     *
     * @param dbOrder
     * @return
     */
    boolean updatePayStatus(UserOrder dbOrder);
}
