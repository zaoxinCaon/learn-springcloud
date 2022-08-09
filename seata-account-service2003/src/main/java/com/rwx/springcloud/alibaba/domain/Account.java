package com.rwx.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 任我行
 * @createDate 2022/8/8  16:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private Long id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal residue;
}
