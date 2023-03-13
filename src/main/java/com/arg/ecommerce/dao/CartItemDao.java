package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.CartItem;
import com.arg.ecommerce.domain.CartItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemDao extends JpaRepository<CartItem, CartItemKey> {

    CartItem findCartItemById(CartItemKey cartItemKey);

}
