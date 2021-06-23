package com.guoshao.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author guoshao
 * @create 2021-06-21 10:01
 */
@Mapper
public interface AccountDao {
    //扣减额度
    void decrease(@Param("userId")Long userId, @Param("money")BigDecimal money);
    //查询余额
    BigDecimal searchAccountResidue(@Param("userId")Long userId);
}
