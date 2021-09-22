package com.dandelion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhanghab
 * @date 2021/9/6
 * @description:
 **/
@SpringBootApplication
@EnableFeignClients
public class MainBoot {
    public static void main(String[] args) {
        SpringApplication.run(MainBoot.class,args);
    }
}
