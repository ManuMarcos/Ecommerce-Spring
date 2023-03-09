package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.CartItemDao;
import com.arg.ecommerce.domain.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    private CartItemDao cartItemDao;


    @Transactional(readOnly = true)
    @Override
    public List<CartItem> listCartItems() {
        return cartItemDao.findAll();
    }

    @Transactional
    @Override
    public void save(CartItem cartItem) {
        cartItemDao.save(cartItem);
    }

    @Transactional
    @Override
    public void delete(CartItem cartItem) {
        cartItemDao.delete(cartItem);
    }

    @Transactional(readOnly = true)
    @Override
    public CartItem findCartItemById(CartItem cartItem) {
        return cartItemDao.findById(cartItem.getIdCartItem()).orElse(null);
    }
}
