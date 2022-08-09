package com.rwx.springcloud.service.impl;

import com.rwx.springcloud.dao.PaymentDao;
import com.rwx.springcloud.entities.Payment;
import com.rwx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 任我行
 * @createDate 2022/7/21  23:18
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
