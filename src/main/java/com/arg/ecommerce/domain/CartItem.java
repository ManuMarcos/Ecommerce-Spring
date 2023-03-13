package com.arg.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "cart_item")
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    CartItemKey id;

    @ManyToOne
    @MapsId("shoppingSessionId")
    @JoinColumn(name = "shoppingSession_id")
    ShoppingSession shoppingSession;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("sizeId")
    @JoinColumn(name = "size_id")
    Size size;

    private int quantity;





}
