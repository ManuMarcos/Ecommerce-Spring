package com.arg.ecommerce.web;


import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ViewsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String inicio(Model model, Product product){
        this.showProducts(model);
        log.info("Ejecutando el controlador Spring MVC");
        return "home";
    }


    @GetMapping("/admin")
    public String admin(Model model, Product product){
        log.info("Ejecutando el controlador de Spring MVC - Get(/admin)");
        this.showProducts(model);
        return "admin";
    }

    private void showProducts(Model model){
        var products = productService.listProducts();
        model.addAttribute("products", products);
    }

    @GetMapping("/editProduct")
    public String editProduct(Product product, Model model){
        product = productService.findProductById(product);
        model.addAttribute("product", product);
        return "editInsertProduct";
    }

}
