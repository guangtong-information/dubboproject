package com.ypy.dubbo.commoninterface.service;

import com.ypy.dubbo.commoninterface.bean.UserAddress;

import java.util.List;

/**
 * 服务提供者接口
 */
public interface UserService {

    /**
     * 按照用户Id返回收货地址
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);

}
