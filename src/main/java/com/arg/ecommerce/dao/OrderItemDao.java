package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer>{

}
