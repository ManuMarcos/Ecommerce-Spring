package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.PaymentDetail;

import java.util.List;

public interface PaymentDetailService {

    public List<PaymentDetail> listPaymentDetails();

    public void save(PaymentDetail paymentDetail);

    public void delete(PaymentDetail paymentDetail);

    public PaymentDetail findPaymentDetailById(PaymentDetail paymentDetail);



}
