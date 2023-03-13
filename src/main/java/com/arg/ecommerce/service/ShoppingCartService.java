package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.ProductSize;
import com.arg.ecommerce.dto.ProductDto;
import com.arg.ecommerce.dto.ProductSizeDto;
import com.arg.ecommerce.dto.ShoppingCartDto;
import com.arg.ecommerce.dto.UserDto;

public interface ShoppingCartService {

    public void addProduct(String userEmail, long productId, long sizeId);

    void removeProduct(long idProduct, int quantity);

    ShoppingCartDto getShoppingCart(long userId);


}
