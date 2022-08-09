package com.rwx.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author 任我行
 * @createDate 2022/8/8  17:18
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
