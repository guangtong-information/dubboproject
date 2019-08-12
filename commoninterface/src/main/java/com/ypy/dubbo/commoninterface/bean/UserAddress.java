package com.ypy.dubbo.commoninterface.bean;

import lombok.Data;
import lombok.ToString;

/**
 * 用户地址
 */
@Data
@ToString
public class UserAddress {

    private Integer id;
    private String userAddress;//用户地址
    private String userId;//用户id
    private String consignee;//收货人
    private String phoneNum;//电话号码
    private String isDefault;//是否为默认地址 Y-是 N-否

    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNum, String isDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
    }

}
