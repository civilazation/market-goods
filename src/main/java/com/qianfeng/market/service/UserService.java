package com.qianfeng.market.service;

import com.qianfeng.market.pojo.entity.User;

/**
 * 关于用户的一些业务操作
 * creator：Administrator
 * date:2019/12/17
 */
public interface UserService {
    /**
     * 登录方法，如果登录成功，返回true，登录失败返回false
     *
     * @param user
     * @return
     */
    boolean login(User user);

    /**
     *
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    void register(User user);
}
