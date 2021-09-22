package com.dandelion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/20 23:43
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class ConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class,args);
    }
}
