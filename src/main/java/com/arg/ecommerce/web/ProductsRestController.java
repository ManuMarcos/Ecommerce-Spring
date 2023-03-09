package com.arg.ecommerce.web;

import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProductsRestController {

    @Autowired
    ProductService productService;

    //Devuelve el producto buscado en formato JSON
    @GetMapping("/product/{idProduct}")
    public ResponseEntity<Product> findProductById(Product product){
        product = productService.findProductById(product);
        if(product != null){
            return ResponseEntity.ok().body(product);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

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
