package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.CartItemDao;
import com.arg.ecommerce.dao.UserDao;
import com.arg.ecommerce.domain.CartItem;
import com.arg.ecommerce.domain.CartItemKey;
import com.arg.ecommerce.domain.User;
import com.arg.ecommerce.dto.ShoppingCartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private CartItemDao cartItemDao;


    @Override
    public void addProduct(String userEmail, long productId, long sizeId) {
        User user = userDao.findUserByEmail(userEmail);

        CartItemKey cartItemKey =  new CartItemKey();
        cartItemKey.setProductId(productId);
        cartItemKey.setSizeId(sizeId);
        cartItemKey.setShoppingSessionId(user.getShoppingSession().getId());

        CartItem cartItem = cartItemDao.findById(cartItemKey).orElse(null);
        if(cartItem != null){
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItemDao.save(cartItem);
        }
        else{
            cartItem =  new CartItem();
            cartItem.setId(cartItemKey);
            cartItem.setQuantity(1);
            cartItemDao.save(cartItem);
        }
    }

    @Override
    public void removeProduct(long idProduct, int quantity) {

    }

    @Override
    public ShoppingCartDto getShoppingCart(long userId) {
        return null;
    }
}
