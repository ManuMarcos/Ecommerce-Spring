package com.arg.ecommerce.dto;

import com.arg.ecommerce.domain.Category;
import com.arg.ecommerce.domain.Discount;
import com.arg.ecommerce.domain.ProductSize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    private Long id;

    private String name;

    private String description;

    private float price;

    private String imgLink;

    private List<Discount> discounts;

    private Category category;

    List<ProductSizeDto> productSizes;


}
