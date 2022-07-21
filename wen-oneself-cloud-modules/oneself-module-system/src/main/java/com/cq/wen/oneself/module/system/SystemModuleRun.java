package com.cq.wen.oneself.module.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.cq.wen.oneself")
@SpringBootApplication
public class SystemModuleRun {

    public static void main(String[] args) {
        SpringApplication.run(SystemModuleRun.class,args);
    }
}
