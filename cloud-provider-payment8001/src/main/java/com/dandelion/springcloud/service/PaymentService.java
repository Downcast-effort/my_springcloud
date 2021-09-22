package com.dandelion.springcloud.service;

import com.dandelion.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/19 22:09
 */
public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
