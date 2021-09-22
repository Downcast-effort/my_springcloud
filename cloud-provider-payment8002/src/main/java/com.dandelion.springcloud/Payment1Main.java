package com.dandelion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/18 22:09
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment1Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment1Main.class, args);
    }
}
