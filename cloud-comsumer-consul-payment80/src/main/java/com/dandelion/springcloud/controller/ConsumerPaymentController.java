package com.dandelion.springcloud.controller;

import com.dandelion.springcloud.entities.CommonResult;
import com.dandelion.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/20 23:48
 */

@RestController
@Slf4j
public class ConsumerPaymentController {

    @Autowired
    private RestTemplate restTemplate;

//    private static final String PROVIDER_UTL="http://localhost:8001";
    private static final String PROVIDER_UTL="http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumerconsul/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PROVIDER_UTL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumerconsul/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PROVIDER_UTL + "/payment/get/" + id, CommonResult.class);
    }
}
