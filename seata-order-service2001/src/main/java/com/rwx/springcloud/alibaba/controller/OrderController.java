package com.rwx.springcloud.alibaba.controller;

import com.rwx.springcloud.alibaba.domain.CommonResult;
import com.rwx.springcloud.alibaba.domain.Order;
import com.rwx.springcloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 任我行
 * @createDate 2022/8/8  12:56
 */
@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功！");
    }

}
