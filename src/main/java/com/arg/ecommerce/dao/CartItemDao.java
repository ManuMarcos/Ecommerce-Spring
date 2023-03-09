package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemDao extends JpaRepository<CartItem, Integer> {

}
