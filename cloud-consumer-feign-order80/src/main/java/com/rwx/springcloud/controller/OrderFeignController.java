package com.rwx.springcloud.controller;

import com.rwx.springcloud.entities.CommonResult;
import com.rwx.springcloud.entities.Payment;
import com.rwx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 任我行
 * @createDate 2022/7/26  16:04
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment){
        log.info("create被调用");
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info(" getPaymentById被调用");
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }

}
