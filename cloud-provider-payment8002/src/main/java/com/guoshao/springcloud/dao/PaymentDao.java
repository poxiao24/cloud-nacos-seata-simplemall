package com.guoshao.springcloud.dao;

import com.guoshao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guoshao
 * @create 2021-06-03 20:44
 */
@Mapper
public interface PaymentDao {
    public int insertPayment(Payment payment);//增
    public int deletePaymentById(@Param("id") Long id);//删
    public int updatePaymentById(Payment payment);//改
    public Payment getPaymentById(@Param("id") Long id);//查
}
