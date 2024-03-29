package com.qianfeng.market.service.impl;

import com.qianfeng.market.dao.AddressDao;
import com.qianfeng.market.pojo.entity.Address;
import com.qianfeng.market.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * creator：Administrator
 * date:2019/12/19
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressDao addressDao;

    @Override
    public Address getDefaultAddress(Integer userId) {
        Address address = addressDao.selectByUserId(userId, "YES");
        if (address == null) {
            address = addressDao.selectByUserId(userId, "NO");
        }
        return address;
    }

    @Override
    public List<Address> getUserAddressList(Integer userId) {

        return addressDao.getUserAddressList(userId);
    }
}
