package com.dandelion.springcloud.impl;

import com.dandelion.springcloud.dao.PaymentDao;
import com.dandelion.springcloud.entities.Payment;
import com.dandelion.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/19 22:10
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
