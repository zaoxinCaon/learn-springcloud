package com.rwx.springcloud.alibaba.service.impl;

import com.rwx.springcloud.alibaba.dao.OrderDao;
import com.rwx.springcloud.alibaba.domain.Order;
import com.rwx.springcloud.alibaba.service.AccountService;
import com.rwx.springcloud.alibaba.service.OrderService;
import com.rwx.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 任我行
 * @createDate 2022/8/8  12:04
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private AccountService accountService;

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    /**
     * 下订单->减库存->减余额->改状态
     * @param order
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order){

        log.info("------->下单开始");
        //本应用创建订单
        orderDao.create(order);

        //远程调用库存服务扣减库存
        log.info("------->order-service中扣减库存开始");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->order-service中扣减库存结束");

        //远程调用账户服务扣减余额
        log.info("------->order-service中扣减余额开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->order-service中扣减余额结束");

        //修改订单状态为已完成
        log.info("------->order-service中修改订单状态开始");
        orderDao.update(order.getId(),1);
        log.info("------->order-service中修改订单状态结束");

        log.info("------->下单结束");

    }

}
