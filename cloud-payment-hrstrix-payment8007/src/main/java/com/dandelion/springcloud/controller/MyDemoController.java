package com.dandelion.springcloud.controller;

import com.dandelion.springcloud.entities.CommonResult;
import com.dandelion.springcloud.service.MyDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author zhanghab
 * @date 2021/9/23
 * @description:
 * 单个服务降级可以采取 @HystrixComand 实现，这样的话fallbackMethod就必须在类中实现，
 * 当出现多个需要降级的方法的时候，就需要定义多个方法，这样会造成代码的冗余
 **/

@RestController
@Slf4j
public class MyDemoController {

    @Autowired
    private MyDemoService demoService;

    /**
     * 测试降级接口
     * @param id
     * @return
     */
    @GetMapping("/hystirx/timeout/{id}")
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


    /**
     * 测试服务熔断就方法
     * @param id
     * @return
     */
    @GetMapping("/hystrix/circuit/{id}")
    public String testCircuitOfHystrix(@PathVariable Integer id){
        return demoService.paymentCircuitBreaker(id);
    }

}
