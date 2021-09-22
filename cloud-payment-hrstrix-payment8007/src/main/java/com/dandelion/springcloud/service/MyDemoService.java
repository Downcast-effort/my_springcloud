package com.dandelion.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhanghab
 * @date 2021/9/23
 * @description:
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



    public String testHystrix(Integer id){
        return "test hystrix" + Thread.currentThread().getName() + "payment info,id:" + id;
    }


    /**
     * Hystrix异常调用方法
     * @return
     */
    public String testHrstrixTimeoutHandler(Integer id){
        return "test hystrix" + Thread.currentThread().getName() + "payment info, sys error";
    }

}
