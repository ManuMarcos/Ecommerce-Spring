package com.arg.ecommerce.controllers;

import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.dto.ProductDto;
import com.arg.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class ProductsController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public String saveProduct(Product product){
        log.info("Ejecutando el controlador ProductsController - Post(/saveProduct)");
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/addProduct")
    public String addProduct(Product product){
        return "editInsertProduct";
    }

    @GetMapping("/deleteProduct")
    public String eliminar(Product product){
        productService.delete(product.getId());
        return "redirect:/admin";
    }

    @GetMapping("/product/{idProduct}")
    public String productDetails(@PathVariable Long idProduct , Model model, Authentication authentication){
        Product product = productService.findProductById(idProduct);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        model.addAttribute("userEmail", authentication.getName());
        model.addAttribute("product", productDto);
        return "product";
    }



}

