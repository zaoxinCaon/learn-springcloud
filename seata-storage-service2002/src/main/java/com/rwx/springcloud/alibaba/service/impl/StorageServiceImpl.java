package com.rwx.springcloud.alibaba.service.impl;

import com.rwx.springcloud.alibaba.dao.StorageDao;
import com.rwx.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 任我行
 * @createDate 2022/8/8  14:33
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("------->storage-service中扣减库存完成");
    }
}
