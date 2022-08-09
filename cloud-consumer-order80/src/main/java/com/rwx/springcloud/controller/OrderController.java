package com.rwx.springcloud.controller;

import com.rwx.springcloud.entities.CommonResult;
import com.rwx.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @author 任我行
 * @createDate 2022/7/22  14:23
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    //----------Object----------------
    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("*****向payment模块请求插入："+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("*****向payment模块获取ID为"+id+"的payment");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    //-------- Entity-----------------
    @GetMapping(value = "/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id){
        log.info("*****向payment模块获取ID为"+id+"的entity");
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

    @PostMapping(value = "/consumer/paymentEntity/create")
    public CommonResult<Payment> createEntity(Payment payment){
        log.info("*****向payment模块请求插入："+payment);
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(
                PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }

}
