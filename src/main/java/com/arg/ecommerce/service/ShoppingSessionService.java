package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.ShoppingSession;

import java.util.List;

public interface ShoppingSessionService {

    public List<ShoppingSession> listShoppingSessions();

    public void save(ShoppingSession shoppingSession);

    public void delete(ShoppingSession shoppingSession);

    public ShoppingSession findShoppingSessionById(ShoppingSession shoppingSession);

}
