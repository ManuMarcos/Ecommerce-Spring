package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.ProductDao;
import com.arg.ecommerce.dao.ProductSizeDao;
import com.arg.ecommerce.dao.SizeDao;
import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.domain.ProductSize;
import com.arg.ecommerce.domain.Size;
import com.arg.ecommerce.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SizeDao sizeDao;

    @Autowired
    private ProductSizeDao productSizeDao;


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
    public void delete(Long id) {
        Product product = this.findProductById(id);
        if(product != null){
            productDao.delete(product);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Product findProductById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    public void addSize(Product product, String value) {
        Size size = sizeDao.findSizeByValue(value);
        if(size != null){
            this.createProductSize(product, size);
        }
        else{
            size = new Size();
            size.setValue(value);
            sizeDao.save(size);
            this.createProductSize(product, size);
        }
    }

    private void createProductSize(Product product, Size size){
        ProductSize productSize = new ProductSize();
        productSize.setProduct(product);
        productSize.setSize(size);
        productSizeDao.save(productSize);
    }


}
