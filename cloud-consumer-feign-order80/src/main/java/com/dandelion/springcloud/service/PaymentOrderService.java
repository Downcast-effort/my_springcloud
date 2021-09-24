package com.dandelion.springcloud.service;

import com.dandelion.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhanghab
 * @date 2021/9/6
 * @description:
 * Feign服务降级
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)
public interface PaymentOrderService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);


    @GetMapping(value = "/comsumer/feign/timeout")
    CommonResult getFeignResult();
}
