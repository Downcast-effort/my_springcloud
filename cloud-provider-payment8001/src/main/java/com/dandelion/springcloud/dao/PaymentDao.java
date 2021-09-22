package com.dandelion.springcloud.dao;

import com.dandelion.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/19 21:54
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
