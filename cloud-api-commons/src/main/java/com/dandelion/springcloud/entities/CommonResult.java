package com.dandelion.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dandelion
 * @version 1.0
 * @date 2021/7/19 21:51
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T data;


    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

    public static CommonResult success(Integer code,String message){
        return new CommonResult(code,message);
    }
    public static CommonResult fail(Integer code,String message){
        return new CommonResult(code,message);
    }
}
