package com.arg.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "cart_item")
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart_item")
    private Integer idCartItem;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private ShoppingSession shoppingSession;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

}
