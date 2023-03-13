package com.arg.ecommerce.controllers;

import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductsRestController {

    @Autowired
    ProductService productService;


    //Devuelve una lista de productos en formato JSON
    @GetMapping("/listProducts")
    public ResponseEntity<List<Product>> listProducts() {
        var productList = productService.listProducts();
        if (!productList.isEmpty()) {
            return ResponseEntity.ok().body(productList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
