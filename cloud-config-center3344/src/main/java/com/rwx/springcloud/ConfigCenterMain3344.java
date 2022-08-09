package com.rwx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 任我行
 * @createDate 2022/7/28  18:00
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigCenterMain3344 {
    public static void main(String[] args) {

        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
