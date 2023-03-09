package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DiscountService {

    public List<Discount> listDiscounts();

    public void save(Discount discount);

    public void delete(Discount discount);

    public Discount findDiscountById(Discount discount);
}
