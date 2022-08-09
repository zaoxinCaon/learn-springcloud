package com.rwx.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 任我行
 * @createDate 2022/8/8  13:01
 */
@Configuration
@MapperScan({"com.rwx.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
