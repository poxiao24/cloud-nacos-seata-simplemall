package com.guoshao.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guoshao
 * @create 2021-06-20 21:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    //`id``product_id``total``used``residue`
    private Long id;
    private Long productId;
    private Integer total;//总库存
    private Integer used;//使用库存
    private Integer residue;//剩余库存
}
