package com.rwx.springcloud.alibaba.service;

import com.rwx.springcloud.alibaba.domain.Order;

/**
 * @author 任我行
 * @createDate 2022/8/8  11:44
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

}
