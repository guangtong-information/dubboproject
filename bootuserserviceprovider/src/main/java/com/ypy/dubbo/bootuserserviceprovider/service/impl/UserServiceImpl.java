package com.ypy.dubbo.bootuserserviceprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ypy.dubbo.commoninterface.bean.UserAddress;
import com.ypy.dubbo.commoninterface.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * 使用注解的方式，将dubbo的服务暴露出去
 */
//@Service(timeout = 2000)
//@Service(version = "1.0.0")
@Service(weight = 100)
public class UserServiceImpl implements UserService {

    public List<UserAddress> getUserAddressList(String userId) {

//        System.out.println("----------验证重试次数1---------");
        System.out.println("----------验证负载均衡20880---------");

        UserAddress userAddress1 = new UserAddress(1,"北京市1","1","李老师","123456789","Y");
        UserAddress userAddress2 = new UserAddress(2,"北京市2","1","李老师","123456789","N");

        /**
         * 模拟dubbo超时属性的设置
         */
        try {
            Thread.sleep(3000);
        } catch (Exception e){

        }

        return Arrays.asList(userAddress1,userAddress2);
    }
}
