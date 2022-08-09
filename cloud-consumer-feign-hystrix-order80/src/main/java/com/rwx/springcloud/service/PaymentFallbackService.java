package com.rwx.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 任我行
 * @createDate 2022/7/27  17:06
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "paymentInfo_Ok服务调用失败，提示来自：cloud-consumer-feign-order80";

    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut服务调用失败，提示来自：cloud-consumer-feign-order80";

    }
}
