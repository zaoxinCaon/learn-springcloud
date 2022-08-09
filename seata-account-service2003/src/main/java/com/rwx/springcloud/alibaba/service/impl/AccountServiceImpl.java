package com.rwx.springcloud.alibaba.service.impl;

import com.rwx.springcloud.alibaba.dao.AccountDao;
import com.rwx.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 任我行
 * @createDate 2022/8/8  17:19
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->order-service中扣减余额开始");
        int x=10/0;
        accountDao.decrease(userId,money);
        log.info("------->order-service中扣减余额开始");
    }
}
