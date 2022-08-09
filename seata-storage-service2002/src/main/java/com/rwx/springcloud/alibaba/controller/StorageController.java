package com.rwx.springcloud.alibaba.controller;

import com.rwx.springcloud.alibaba.domain.CommonResult;
import com.rwx.springcloud.alibaba.service.StorageService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 任我行
 * @createDate 2022/8/8  14:39
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"库存修改成功");
    }
}
