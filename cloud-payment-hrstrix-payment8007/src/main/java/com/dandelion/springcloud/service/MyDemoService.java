package com.dandelion.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhanghab
 * @date 2021/9/23
 * @description:
 * 单个服务降级可以采取 @HystrixComand 实现，这样的话fallbackMethod就必须在类中实现，
 * 当出现多个需要降级的方法的时候，就需要定义多个方法，这样会造成代码的冗余
 **/

@Service
@Slf4j
public class MyDemoService {


    /**
     * 降级接口编写
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "testHrstrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name  = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String testHrstrixTimeout(Integer id){
        try {
            Thread.sleep(id);
        }catch (Exception e){
            log.warn(e.getMessage());
        }
        return "test hrstirx timeout" + " " + id + " s";
    }


    /**
     * 正常的测试方法
     * @param id
     * @return
     */
    public String testHystrix(Integer id){
        return "test hystrix" + Thread.currentThread().getName() + "payment info,id:" + id;
    }


    /**
     * 服务熔断
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value  = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value  = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMillilseconds",value  = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value  = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("***** id 不能负数");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName()  + "调用成功，流水号：" + serialNum;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return Thread.currentThread().getName()  + "调用发生sys error，id：" + id;
    }

}
