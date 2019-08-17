package com.ypy.dubbo.commoninterface.service;

import com.ypy.dubbo.commoninterface.bean.UserAddress;

import java.util.List;

/**
 * 定义本地存根
 * 1、服务发现者调用服务提供方的时候，先调用本地存根
 * 2、本地存根验证通过以后，在真正调用服务发现者
 */
public class UserServiceStub implements UserService {

    private UserService userService;

    /**
     * 必须要定义构造函数
     * @param userService 本地存根调用的时候，传入的是userService远程代理对象
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        // 校验前置参数
        if (userId != null && !userId.equals("")) {
            System.out.println("本地存根验证通过，继续调用服务提供方！");
            return userService.getUserAddressList(userId);
        }
        System.out.println("本地存根验证不通过，服务调用终止!");
        return null;
    }
}
