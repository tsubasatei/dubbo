package com.xt.gmall.service;

import com.xt.gmall.bean.UserAddress;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * 按照用户ID返回所有的收获地址
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddressList(String userId);
}
