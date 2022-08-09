package com.rwx.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rwx.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 任我行
 * @createDate 2022/7/27  7:44
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    //正常访问
    public String paymentInfo_Ok(Integer id){
        return "线程池："+ Thread.currentThread().getName()+"paymentInfo_Ok,id:"+id+"\t"+"(*^_^*)";
    }


    //访问超时
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+ Thread.currentThread().getName()+"paymentInfo_Ok,id:"+id+"\t"+"/(ㄒoㄒ)/~~，耗费5秒";
    }
    public String paymentInfo_TimeOutHandler(Integer id){
        return "/(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }


    //========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
                    commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启熔断
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数超过了峰值，
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")})//失效率达到多少后跳闸
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请稍后再试，/(ㄒoㄒ)/~~  id:"+ id;
    }

}
