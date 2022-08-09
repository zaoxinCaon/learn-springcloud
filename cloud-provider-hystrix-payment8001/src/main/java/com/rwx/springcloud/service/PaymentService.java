package com.rwx.springcloud.service;

/**
 * @author 任我行
 * @createDate 2022/7/27  7:40
 */

public interface PaymentService {
    //正常访问
    public String paymentInfo_Ok(Integer id);
    //访问超时
    public String paymentInfo_TimeOut(Integer id);
    public String paymentInfo_TimeOutHandler(Integer id);

    public String paymentCircuitBreaker(Integer id);
    public String paymentCircuitBreaker_fallback(Integer id);
}
