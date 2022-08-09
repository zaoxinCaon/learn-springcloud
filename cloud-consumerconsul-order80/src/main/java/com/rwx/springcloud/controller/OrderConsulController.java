package com.rwx.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 任我行
 * @createDate 2022/7/24  23:28
 */
@Slf4j
@RestController
public class OrderConsulController {
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        log.info("消费者调用支付服务(consul)--->result:" + result);
        return result;
    }
}
