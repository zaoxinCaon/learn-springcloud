package com.rwx.springcloud.alibaba.dao;

import com.rwx.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 任我行
 * @createDate 2022/8/8  10:57
 */
@Mapper
public interface OrderDao {

    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);

    /**
     * 修改订单状态
     * @param id
     * @param status
     */
    void update(@Param("id") Long id,@Param("status") Integer status);

    /**
     * 按订单号查询订单
     * @param id
     * @return
     */
    Order selectById(@Param("id") Long id);
}
