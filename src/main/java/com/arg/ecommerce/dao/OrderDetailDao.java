package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {

}
