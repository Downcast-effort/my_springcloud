package com.dandelion.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghab
 * @date 2021/10/17
 * @description:
 **/

@RestController
public class PaymentController {

    @Value("${server.port}")
    String serverPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos registry,server port:" + serverPort + "\tid:" + id;
    }
}
