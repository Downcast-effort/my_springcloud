package com.dandelion.springcloud.service;

import com.dandelion.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentOrderService{
    @Override
    public CommonResult getPaymentById(Long id) {
        return CommonResult.fail(0,"Sys error");
    }

    @Override
    public CommonResult getFeignResult() {
        return CommonResult.fail(0,"Sys error");
    }
}
