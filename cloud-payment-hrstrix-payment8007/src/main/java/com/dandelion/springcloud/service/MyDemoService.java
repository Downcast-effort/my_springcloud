package com.dandelion.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


}
