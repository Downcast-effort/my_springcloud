package com.dandelion.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhanghab
 * @date 2021/8/11
 * @description:
 **/
@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced    //Ribbon的负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
