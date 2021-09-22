package com.dandelion.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanghab
 * @date 2021/9/6
 * @description:
 **/
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLog(){
        return Logger.Level.FULL;

    }
}
