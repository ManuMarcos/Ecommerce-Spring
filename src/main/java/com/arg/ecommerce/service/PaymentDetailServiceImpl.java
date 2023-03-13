package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.PaymentDetailDao;
import com.arg.ecommerce.domain.PaymentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentDetailServiceImpl implements PaymentDetailService{

    @Autowired
    private PaymentDetailDao paymentDetailDao;


    @Transactional(readOnly = true)
    @Override
    public List<PaymentDetail> listPaymentDetails() {
        return paymentDetailDao.findAll();
    }

    @Transactional
    @Override
    public void save(PaymentDetail paymentDetail) {
        paymentDetailDao.save(paymentDetail);
    }

    @Transactional
    @Override
    public void delete(PaymentDetail paymentDetail) {
        paymentDetailDao.delete(paymentDetail);
    }

    @Transactional(readOnly = true)
    @Override
    public PaymentDetail findPaymentDetailById(PaymentDetail paymentDetail) {
        return paymentDetailDao.findById(paymentDetail.getId()).orElse(null);
    }
}
