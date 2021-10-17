package com.dandelion.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhanghab
 * @date 2021/10/17
 * @description:
 **/

@SpringBootApplication
@EnableDiscoveryClient
public class MainBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainBootApplication.class,args);
    }
}
