package com.cq.wen.oneself.network.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Title: AuthNetworkRun
 * @Author wen
 * @Date: 2022/7/20 13:19
 */
@EnableFeignClients(basePackages = "com.cq.wen.oneself")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AuthNetworkRun {
    public static void main(String[] args) {
        SpringApplication.run(AuthNetworkRun.class,args);
    }
}
