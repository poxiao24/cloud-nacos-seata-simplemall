package com.guoshao.springcloud.service.impl;

import com.guoshao.springcloud.dao.PaymentDao;
import com.guoshao.springcloud.entities.Payment;
import com.guoshao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author guoshao
 * @create 2021-06-03 21:33
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public int deletePaymentById(Long id) {
        return paymentDao.deletePaymentById(id);
    }

    @Override
    public int updatePaymentById(Payment payment) {
        return paymentDao.updatePaymentById(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
