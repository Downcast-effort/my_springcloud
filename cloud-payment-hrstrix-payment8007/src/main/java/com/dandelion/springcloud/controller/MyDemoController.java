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


}
