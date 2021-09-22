package com.dandelion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhanghab
 * @date 2021/9/21
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HrstrixPaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(HrstrixPaymentMain.class,args);
    }
}
