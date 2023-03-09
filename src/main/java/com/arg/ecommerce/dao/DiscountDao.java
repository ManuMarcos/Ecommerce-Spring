package com.arg.ecommerce.dao;


import com.arg.ecommerce.domain.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountDao extends JpaRepository<Discount, Integer> {

}
