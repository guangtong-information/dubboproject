package com.ypy.dubbo.bootuserserviceprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ypy.dubbo.commoninterface.bean.UserAddress;
import com.ypy.dubbo.commoninterface.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * 使用注解的方式，将dubbo的服务暴露出去
 */
@Service
public class UserServiceImpl implements UserService {

    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress1 = new UserAddress(1,"北京市1","1","李老师","123456789","Y");
        UserAddress userAddress2 = new UserAddress(2,"北京市2","1","李老师","123456789","N");

        return Arrays.asList(userAddress1,userAddress2);
    }
}
