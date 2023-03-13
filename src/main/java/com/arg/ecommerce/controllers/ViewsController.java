package com.arg.ecommerce.controllers;


import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.domain.User;
import com.arg.ecommerce.dto.UserDto;
import com.arg.ecommerce.service.CategoryService;
import com.arg.ecommerce.service.ProductService;
import com.arg.ecommerce.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
@Slf4j
public class ViewsController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


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

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/login")
    public String getUserLoginPage(){
        if(isAunthenticated()){
            return "redirect:/";
        }
        return "login";
    }


    @GetMapping("/editProduct")
    public String editProduct(Product product, Model model){
        product = productService.findProductById(product.getId());
        model.addAttribute("product", product);
        this.showCategories(model);
        return "editInsertProduct";
    }

    @GetMapping("/createProduct")
    public String createProduct(Product product, Model model){
        this.showCategories(model);
        return "editInsertProduct";
    }


    private void showProducts(Model model){
        var products = productService.listProducts();
        model.addAttribute("products", products);
    }

    private void showCategories(Model model){
        var categories = categoryService.listCategories();
        model.addAttribute("categories", categories);
    }

    private boolean isAunthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken){
            return false;
        }
        return authentication.isAuthenticated();
    }

}
