package com.ypy.dubbo.orderserviceconsumer.service;

import com.ypy.dubbo.commoninterface.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.initOrder("1");
        System.out.println("调用完成");

        // 阻塞，以便可以在DubboAdmin的管理控制台，查看服务消费者上线
        System.in.read();
    }
}
