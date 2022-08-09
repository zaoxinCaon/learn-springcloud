package com.rwx.springcloud.alibaba.controller;

import com.rwx.springcloud.alibaba.domain.Account;
import com.rwx.springcloud.alibaba.domain.CommonResult;
import com.rwx.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author 任我行
 * @createDate 2022/8/8  17:30
 */
//扣余额
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣余额成功");
    }
}
