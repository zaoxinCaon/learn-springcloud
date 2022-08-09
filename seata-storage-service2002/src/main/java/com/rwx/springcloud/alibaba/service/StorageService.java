package com.rwx.springcloud.alibaba.service;

/**
 * @author 任我行
 * @createDate 2022/8/8  14:29
 */
public interface StorageService {

    void decrease(Long productId,Integer count);
}
