package com.ypy.dubbo.userserviceprovider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider.xml");
        ((ClassPathXmlApplicationContext) applicationContext).start();

        // 为了主进程不退出，阻塞在此
        System.in.read();
    }

}
