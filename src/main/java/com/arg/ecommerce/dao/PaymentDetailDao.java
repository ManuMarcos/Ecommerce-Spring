package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.OrderDetail;
import com.arg.ecommerce.domain.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailDao extends JpaRepository<PaymentDetail, Integer> {
}
