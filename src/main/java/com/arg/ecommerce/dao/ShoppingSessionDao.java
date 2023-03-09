package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingSessionDao extends JpaRepository<ShoppingSession, Integer> {

}
