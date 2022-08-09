package com.rwx.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 任我行
 * @createDate 2022/8/8  16:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T Data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

}
