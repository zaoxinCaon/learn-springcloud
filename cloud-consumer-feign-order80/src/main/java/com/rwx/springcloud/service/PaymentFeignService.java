package com.rwx.springcloud.service;

import com.rwx.springcloud.entities.CommonResult;
import com.rwx.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 任我行
 * @createDate 2022/7/26  15:56
 */
@Component
@FeignClient(value ="CLOUD-PAYMENT-SERVICE" )
public interface PaymentFeignService {

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut();

}
