package com.arg.ecommerce.web;

import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public String saveProduct(Product product, Errors errors){
        if(errors.hasErrors()){
            return "insertProducts";
        }
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/addProduct")
    public String addProduct(Product product){
        return "editInsertProduct";
    }

}
