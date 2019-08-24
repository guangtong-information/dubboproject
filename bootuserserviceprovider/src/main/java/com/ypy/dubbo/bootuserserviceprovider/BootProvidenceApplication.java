package com.ypy.dubbo.bootuserserviceprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDubbo // 开启基于注解的dubbbo功能
@EnableHystrix // 开启服务容错功能
@SpringBootApplication
public class BootProvidenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootProvidenceApplication.class,args);
    }

}
