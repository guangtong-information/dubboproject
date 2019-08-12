package com.ypy.dubbo.userserviceproject.service.impl;

import com.ypy.dubbo.commoninterface.bean.UserAddress;
import com.ypy.dubbo.commoninterface.service.OrderService;
import com.ypy.dubbo.commoninterface.service.UserService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private UserService userService;

    public void initOrder(String userId) {
        // 1.查询用户的收货地址
        List<UserAddress> userAddresses = userService.getUserAddressList(userId);
        for(UserAddress userAddress : userAddresses){
            System.out.println(userAddress);
        }
    }
}
