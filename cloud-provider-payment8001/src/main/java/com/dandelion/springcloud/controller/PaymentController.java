package com.dandelion.springcloud.controller;

import com.dandelion.springcloud.entities.CommonResult;
import com.dandelion.springcloud.entities.Payment;
import com.dandelion.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/19 22:13
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("【支付模块】插入数据的结果为：" +result);
        if (result > 0){
            return new CommonResult(200,"插入数据成功,serverPort:" + serverPort,result);
        }else{
            return new CommonResult(414,"插入数据失败",null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
         Payment payment = paymentService.getPaymentById(id);
        log.info("【支付模块】查询数据的结果为：" +payment);
        if (null != payment){
            return new CommonResult(200,"查询数据成功,serverPort:" + serverPort,payment);
        }else{
            return new CommonResult(404,"未查询到相应记录" + id,null);
        }
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> serviceInstances = discoveryClient.getServices();
        for(String ele: serviceInstances){
            log.info("****" + ele);
        }

        List<ServiceInstance> serviceInstances1 = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:serviceInstances1){
            log.info("serviceId: " + serviceInstance.getServiceId() + "\t" + "host: " + serviceInstance.getHost() + "\t" + "port: "+ serviceInstance.getPort());
        }
        return discoveryClient;
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
