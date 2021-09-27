package com.dandelion.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientMainAppication {
    public static void main(String[] args) {
        SpringApplication.run(ClientMainAppication.class,args);
    }
}
