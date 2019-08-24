package com.ypy.dubbo.bootuserserviceprovider3;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDubbo(scanBasePackages = {"com.ypy.dubbo.bootuserserviceprovider2"}) // 开启基于注解的dubbbo功能，主要是用于包扫描，等同于配置文件application.properties中定义：dubbo.scan.base-packages=com.ypy.dubbo.bootuserserviceprovider
@DubboComponentScan(basePackages = {"com.ypy.dubbo.bootuserserviceprovider2"})
@SpringBootApplication
public class BootProvidenceApplication3 {

    public static void main(String[] args) {
        SpringApplication.run(BootProvidenceApplication3.class,args);
    }

}
