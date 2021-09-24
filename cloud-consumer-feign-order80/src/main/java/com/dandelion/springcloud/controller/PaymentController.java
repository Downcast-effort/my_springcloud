package com.dandelion.springcloud.controller;

import com.dandelion.springcloud.entities.CommonResult;
import com.dandelion.springcloud.service.PaymentOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghab
 * @date 2021/9/6
 * @description:
 **/
@RestController
public class PaymentController {

    @Resource
    private PaymentOrderService paymentOrderService;

    @GetMapping(value = "/comsumer/feign/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentOrderService.getPaymentById(id);
    }


    @GetMapping(value = "/comsumer/feign/timeout")
    CommonResult getFeignResult(){
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new CommonResult(1,"成功");
    }

}
