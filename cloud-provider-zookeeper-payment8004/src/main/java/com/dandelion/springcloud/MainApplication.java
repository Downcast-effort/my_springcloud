package com.dandelion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhanghab
 * @date 2021/8/11
 * @description:
 **/
@SpringBootApplication
@EnableDiscoveryClient //该注解主要用于consul或者zookeeper作为注册中心时注册服务
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
