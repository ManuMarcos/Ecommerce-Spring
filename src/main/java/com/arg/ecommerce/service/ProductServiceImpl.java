package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.ProductDao;
import com.arg.ecommerce.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;


    @Transactional(readOnly = true)
    @Override
    public List<Product> listProducts() {
        return productDao.findAll();
    }

    @Transactional
    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Transactional(readOnly = true)
    @Override
    public Product findProductById(Product product) {
        return productDao.findById(product.getIdProduct()).orElse(null);
    }
}
