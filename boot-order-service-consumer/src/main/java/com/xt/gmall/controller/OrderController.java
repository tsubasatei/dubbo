package com.xt.gmall.controller;

import com.xt.gmall.bean.UserAddress;
import com.xt.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xt
 * @create 2019/5/24 9:27
 * @Desc
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/listUserAddress/{userId}")
    public List<UserAddress> listUserAddress(@PathVariable("userId") String userId) {
        return orderService.initOrder(userId);
    }
}
