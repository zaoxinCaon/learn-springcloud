package com.rwx.springcloud.service;

import com.rwx.springcloud.entities.Payment;

/**
 * @author 任我行
 * @createDate 2022/7/21  23:16
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
