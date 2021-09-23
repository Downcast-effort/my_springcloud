package com.dandelion.springcloud.controller;

import com.dandelion.springcloud.entities.CommonResult;
import com.dandelion.springcloud.service.MyDemoService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zhanghab
 * @date 2021/9/23
 * @description:
 * 由于MyDemoService中每一个方法都会进行fallbackMethod,造成严重的代码冗余
 * Hystrix中存在 默认全局降级处理 @DefaultProperties
 **/


@RestController
@Slf4j
@DefaultProperties(defaultFallback = "testHrstrixTimeoutHandler")
public class MyDemoDefaultController {
    @Autowired
    private MyDemoService demoService;

    /**
     * 测试降级接口
     * @param id
     * @return
     */
    @GetMapping("/hystirx/timeout/{id}")
    @HystrixCommand
    public CommonResult<String> testTimeOut(@PathVariable Integer id){
        String result = demoService.testHrstrixTimeout(id);
        return CommonResult.success(1,result);
    }


    /**
     * Hystrix异常调用方法
     * @return
     */
    public String testHrstrixTimeoutHandler(Integer id){
        return "test hystrix" + Thread.currentThread().getName() + "payment info, sys error";
    }
}
