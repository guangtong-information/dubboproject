package com.ypy.dubbo.bootorderserviceconsumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ypy.dubbo.commoninterface.bean.UserAddress;
import com.ypy.dubbo.commoninterface.service.OrderService;
import com.ypy.dubbo.commoninterface.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 使用注解的方式，获取远程的dubbo方法调用
     */
    @Reference
    private UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        // 需要查询用户的收货地址
        List<UserAddress> userAddresses = userService.getUserAddressList(userId);
        for(UserAddress userAddress : userAddresses){
            System.out.println(userAddress);
        }
        return userAddresses;
    }
}
