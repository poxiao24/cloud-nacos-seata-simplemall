package com.guoshao.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author guoshao
 * @create 2021-06-21 9:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    //`id``user_id``total``used``residue`
    private Long id;
    private Long userId;
    private Integer total;//总额度
    private Integer used;//使用额度
    private Integer residue;//剩余额度
}
