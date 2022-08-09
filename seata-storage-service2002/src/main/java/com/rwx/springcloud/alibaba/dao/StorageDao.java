package com.rwx.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 任我行
 * @createDate 2022/8/8  13:51
 */

@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
