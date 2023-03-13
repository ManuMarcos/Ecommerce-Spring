package com.arg.ecommerce.dao;

import com.arg.ecommerce.domain.ProductSize;
import com.arg.ecommerce.domain.ProductSizeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeDao extends JpaRepository<ProductSize, ProductSizeKey> {

}
