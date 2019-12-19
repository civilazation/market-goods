package com.qianfeng.market.service;

import com.qianfeng.market.pojo.entity.Address;

import java.util.List;

/**
 * creator：Administrator
 * date:2019/12/19
 */
public interface AddressService {

    Address getDefaultAddress(Integer userId);

    /**
     * 查询用户所有收货地址，以供用户进行选择
     *
     * @param userId
     * @return
     */
    List<Address> getUserAddressList(Integer userId);
}
