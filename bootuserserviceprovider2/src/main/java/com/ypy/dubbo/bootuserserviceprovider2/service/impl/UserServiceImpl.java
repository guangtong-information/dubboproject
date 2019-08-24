package com.ypy.dubbo.bootuserserviceprovider2.service.impl;

import com.ypy.dubbo.commoninterface.bean.UserAddress;
import com.ypy.dubbo.commoninterface.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {

    public List<UserAddress> getUserAddressList(String userId) {

//        System.out.println("----------验证重试次数1---------");
        System.out.println("----------验证负载均衡20882---------");

        UserAddress userAddress1 = new UserAddress(1,"北京市1","1","李老师","123456789","Y");
        UserAddress userAddress2 = new UserAddress(2,"北京市2","1","李老师","123456789","N");

        /**
         * 模拟dubbo超时属性的设置
         */
       /* try {
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }*/

        return Arrays.asList(userAddress1,userAddress2);
    }
}
