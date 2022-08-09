package com.rwx.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 任我行
 * @createDate 2022/8/8  14:52
 */
@Configuration
@MapperScan(value = "com.rwx.springcloud.alibaba.dao")
public class MyBaitsConfig {
}
