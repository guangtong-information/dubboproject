package com.ypy.dubbo.bootuserserviceprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo // 开启基于注解的dubbbo功能
@SpringBootApplication
public class BootProvidenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootProvidenceApplication.class,args);
    }

}
