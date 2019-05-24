package com.xt.gmall.service.impl;

import com.xt.gmall.bean.UserAddress;
import com.xt.gmall.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;


public class UserServiceStub implements UserService {
	
	private final UserService userService;

	/**
	 * 传入的是userService远程的代理对象
	 */
	public UserServiceStub(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceStub.....");
		if (!StringUtils.isEmpty(userId)) {
			return userService.getUserAddressList(userId);
		}
		return null;
	}
}