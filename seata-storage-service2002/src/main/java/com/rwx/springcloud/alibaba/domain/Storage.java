package com.rwx.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @author 任我行
 * @createDate 2022/8/8  13:34
 */

//库存类
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Storage {

    private Long id;

    private Long productId;

    private Integer total;  //总库存

    private Integer used;   //已使用

    private Integer residue; //剩余库存
}
