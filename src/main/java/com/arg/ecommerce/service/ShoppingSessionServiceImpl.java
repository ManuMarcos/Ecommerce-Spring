package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.ShoppingSessionDao;
import com.arg.ecommerce.domain.ShoppingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingSessionServiceImpl implements ShoppingSessionService {

    @Autowired
    private ShoppingSessionDao shoppingSessionDao;

    @Transactional(readOnly = true)
    @Override
    public List<ShoppingSession> listShoppingSessions() {
        return shoppingSessionDao.findAll();
    }

    @Transactional
    @Override
    public void save(ShoppingSession shoppingSession) {
        shoppingSessionDao.save(shoppingSession);
    }

    @Transactional
    @Override
    public void delete(ShoppingSession shoppingSession) {
        shoppingSessionDao.delete(shoppingSession);
    }

    @Transactional(readOnly = true)
    @Override
    public ShoppingSession findShoppingSessionById(ShoppingSession shoppingSession) {
        return shoppingSessionDao.findById(shoppingSession.getIdShoppingSession()).orElse(null);
    }
}
