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
     * 知识点16：重试次数 retries = 2（默认为）
     * （1）因为网络等原因，服务调用失败的时候，服务会重新调用
     * （2）当服务提供者有多个的时候，会分别取调用，不会再一棵树上吊死
     * （3）幂等性的操作，例如查询、修改和删除，才可以加重试次数
     * （4）dubbo默认的重试次数为2
     * （5）重试次数一般和超时设置同时使用
     *
     * 知识点17：多版本 version = "1.0.0" 或者 version = "1.1.0" 或者 version = "*"（随机调用）
     * （1）当服务升级，为了兼容需求，可以根据版本号可以实现平滑过渡
     * （2）或者实现灰度发布的过程
     *
     * 知识点18：本地存根 stub = "com.ypy.dubbo.gmallinterface.service.UserServiceStub"
     *
     * 知识点19【！！！注意！！！】：dubbo与springboot整合方式三的时候，测试只能使用@Reference，不要增加枚举参数
     *
     * 知识点20：dubbo直连，消费端直接访问服务提供者，绕过注册中心 url = "127.0.0.1:20880"
     *
     * 知识点21：负载均衡机制
     * （1）loadbalance = “random”，于权重的随机负载均衡机制（默认负载均衡策略）
     * （2）loadbalance = "roundrobin"，于权重的轮询负载均衡机制
     * （3）loadbalance = "leastactive"，最少活跃数负载均衡（挑选上一次请求调用时间最少的访问）
     *
     */
//    @Reference(check = false,timeout = 2000,retries = 2,version = "*")
//    @Reference(check = false,timeout = 2000,retries = 2,version = "1.0.0",stub = "com.ypy.dubbo.commoninterface.service.UserServiceStub",url = "127.0.0.1:20880")
    @Reference(check = false,timeout = 2000,retries = 2,loadbalance = "roundrobin" )
//    @Reference(check = false)
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
