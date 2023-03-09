package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.DiscountDao;
import com.arg.ecommerce.domain.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService{

    @Autowired
    private DiscountDao discountDao;

    @Transactional(readOnly = true)
    @Override
    public List<Discount> listDiscounts() {
        return discountDao.findAll();
    }

    @Transactional
    @Override
    public void save(Discount discount) {
        discountDao.save(discount);
    }

    @Transactional
    @Override
    public void delete(Discount discount) {
        discountDao.delete(discount);
    }

    @Transactional(readOnly = true)
    @Override
    public Discount findDiscountById(Discount discount) {
        return discountDao.findById(discount.getIdDiscount()).orElse(null);
    }
}
