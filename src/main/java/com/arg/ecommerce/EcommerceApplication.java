package com.arg.ecommerce;

import com.arg.ecommerce.domain.Category;
import com.arg.ecommerce.domain.Product;
import com.arg.ecommerce.service.ProductService;
import com.arg.ecommerce.service.ProductServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);

    }

}
