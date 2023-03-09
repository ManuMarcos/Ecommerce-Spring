package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.CartItem;

import java.util.List;

public interface CartItemService {

    public List<CartItem> listCartItems();

    public void save(CartItem cartItem);

    public void delete(CartItem cartItem);

    public CartItem findCartItemById(CartItem cartItem);



}
