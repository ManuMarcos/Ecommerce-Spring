package com.arg.ecommerce.dto;

import lombok.Data;

@Data
public class ProductSizeDto {

    private ProductDto productDto;

    private SizeDto size;

    private int quantity;

}
