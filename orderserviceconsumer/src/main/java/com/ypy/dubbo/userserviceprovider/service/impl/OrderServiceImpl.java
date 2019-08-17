package com.ypy.dubbo.userserviceprovider.service.impl;

import com.ypy.dubbo.commoninterface.bean.UserAddress;
import com.ypy.dubbo.commoninterface.service.OrderService;
import com.ypy.dubbo.commoninterface.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    public List<UserAddress> initOrder(String userId) {
        List<UserAddress> userAddresses = userService.getUserAddressList(userId);
        for(UserAddress userAddress : userAddresses){
            System.out.println(userAddress);
        }
        return userAddresses;
    }
}
