package com.ypy.dubbo.commoninterface.service;

import com.ypy.dubbo.commoninterface.bean.UserAddress;

import java.util.List;

/**
 * 服务消费者接口
 */
public interface OrderService {

    /**
     * 初始化订单
     * @param userId
     */
    public List<UserAddress> initOrder(String userId);

}
