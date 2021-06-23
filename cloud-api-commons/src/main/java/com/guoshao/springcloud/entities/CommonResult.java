package com.guoshao.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 传给前端的json数据
 * code显示成功与否，返回代码200、404.。。。。前端只用判断然后走不同逻辑
 * message用来友好提醒
 * 泛型用来存放不同数据
 * @author guoshao
 * @create 2021-06-03 20:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {//一个可能不存在返回数据的初始构造器
       this(code,message,null);
    }
}
