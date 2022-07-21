package com.cq.wen.oneself.network.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Title: GatewayNetworkRun
 * @Author wen
 * @Date: 2022/7/20 13:40
 */
@EnableFeignClients(basePackages = "com.cq.wen.oneself")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GatewayNetworkRun {
    public static void main(String[] args) {
        SpringApplication.run(GatewayNetworkRun.class,args);
    }
}
