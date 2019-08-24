package com.ypy.dubbo.bootuserserviceprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = "classpath:provider.xml")
@SpringBootApplication
public class BootProvidenceApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(BootProvidenceApplication2.class,args);
    }

}
