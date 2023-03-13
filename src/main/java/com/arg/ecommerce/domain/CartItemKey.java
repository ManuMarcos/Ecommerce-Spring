package com.arg.ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class CartItemKey implements Serializable {

    @Column(name = "product_id")
    Long productId;

    @Column(name = "size_id")
    Long sizeId;

    @Column(name = "shoppingSession_id")
    Long shoppingSessionId;

}
