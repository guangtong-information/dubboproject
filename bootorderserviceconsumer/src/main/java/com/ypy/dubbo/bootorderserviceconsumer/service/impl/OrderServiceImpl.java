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
     * 知识点12：使用注解调用远程服务
     * （1）使用注解的方式，获取远程的dubbo方法调用
     *
     * 知识点14：启动检查 check = false
     * （1）设置单个dubbo服务，check = false：启动不检查远程的服务是否存在。
     * （2）远程服务调用很多，一一配置麻烦，可以配置当前消费者的统一规则：所有服务都启动不检 dubbo.consumer.check=false
     * （3）默认需要检查；如果没有远程服务没有，启动的时候会输出如下异常：Failed to check the status of the service
     *
     * 知识点15：服务超时设置 timeout = 5000
     * （1）解决因为服务端一致没有响应的情况下，可能导致调用端大量线程的阻塞，可以设置服务超时时间。
     * （2）默认的超时时间为1s
     *
     */
    @Reference(check = false,timeout = 1000)
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
