package com.xt.gmall.service.impl;

import com.xt.gmall.bean.UserAddress;
import com.xt.gmall.service.OrderService;
import com.xt.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1. 将服务器提供者注册到注册中心 (暴露服务)
 *      1） 导入 dubbo 依赖
 * 2. 让服务消费者去注册中心订阅服务提供者的服务地址
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    public void initOrder(String userId) {
        System.out.println("用户id: " + userId);
        // 1. 查询用户的收获地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        userAddressList.stream().forEach(System.out::println);
    }
}
