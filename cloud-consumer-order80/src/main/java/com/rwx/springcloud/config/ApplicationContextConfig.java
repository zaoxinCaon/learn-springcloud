package com.rwx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 任我行
 * @createDate 2022/7/22  14:27
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
