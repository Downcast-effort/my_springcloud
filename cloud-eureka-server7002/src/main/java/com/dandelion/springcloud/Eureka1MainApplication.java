package com.dandelion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/26 17:41
 */

@SpringBootApplication
@EnableEurekaServer
public class Eureka1MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1MainApplication.class,args);
    }
}
