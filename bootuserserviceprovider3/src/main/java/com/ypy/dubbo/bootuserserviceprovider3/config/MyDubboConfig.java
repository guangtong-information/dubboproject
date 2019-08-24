package com.ypy.dubbo.bootuserserviceprovider3.config;

import com.alibaba.dubbo.config.*;
import com.ypy.dubbo.commoninterface.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 方式三：dubbo与springboot的结合
 * 注解API，公共的配置类
 */
@Configuration
public class MyDubboConfig {

    // #1.指定当前服务/应用的名称
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("bootuserserviceprovider3");
        return applicationConfig;
    }

    // #2.指定注册中心的位置
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    // #3.指定服务提供者和服务消费者之间的通信规则（包括：通信的协议和通信的端口）
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20083);
        return protocolConfig;
    }

    // 4.配置监控中心的地址（采用方式一：默认从注册中心获取监控中心的地址）
    @Bean
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

    /**
     * // 5.配置dubbo服务提供者，暴露服务
     * springboot会自动注入UserService对象
     */
    @Bean
    public ServiceConfig<UserService> userServiceServiceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
//        serviceConfig.setVersion("2.0.0");

        //配置每一个Method
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        List<MethodConfig> methodConfigs = new ArrayList<>();
        methodConfigs.add(methodConfig);

        serviceConfig.setMethods(methodConfigs);
        return serviceConfig;
    }
}
