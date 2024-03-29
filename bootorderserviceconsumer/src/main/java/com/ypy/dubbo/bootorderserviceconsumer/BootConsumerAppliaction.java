package com.ypy.dubbo.bootorderserviceconsumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDubbo //开启基于注解的dubbbo功能
@EnableHystrix //开启Hystrix集群容错
@SpringBootApplication
public class BootConsumerAppliaction {

    public static void main(String[] args) {

        SpringApplication.run(BootConsumerAppliaction.class,args);
        // 或者
        /*SpringApplication springApplication = new SpringApplication(Appliaction.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);*/
    }

}
