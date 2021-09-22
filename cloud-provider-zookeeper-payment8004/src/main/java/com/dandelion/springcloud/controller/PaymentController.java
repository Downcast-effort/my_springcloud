package com.dandelion.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhanghab
 * @date 2021/8/11
 * @description:
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/payment/zk")
    public String paymentZk(){
        return "Spring cloud with zookeeper" + serverPort + UUID.randomUUID().toString();
    }
}
