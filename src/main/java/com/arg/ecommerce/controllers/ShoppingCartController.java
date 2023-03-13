package com.arg.ecommerce.controllers;

import com.arg.ecommerce.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/product/{productId}/{sizeId}")
    public String addProductToCart(@PathVariable Long productId, @PathVariable Long sizeId, Authentication authentication){
        shoppingCartService.addProduct(authentication.getName(),productId, sizeId);
        log.info("Ejecutando el ShoppingCartController - addProductToCart");
        return "home";
    }


}
