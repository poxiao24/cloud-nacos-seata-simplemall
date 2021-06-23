package com.guoshao.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guoshao
 * @create 2021-06-21 9:15
 */
@Mapper
public interface StorageDao {
    //扣减库存信息
    void decrease(@Param("productId") Long productId,@Param("count") Integer count);

    //查询库存余额
    Integer searchProductResidue(@Param("productId")Long productId);
}
