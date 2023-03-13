package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> listProducts();

    void save(Product product);

    void delete(Long id);

    Product findProductById(Long id);

    void addSize(Product product, String size);

}
