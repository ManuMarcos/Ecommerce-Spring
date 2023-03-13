package com.arg.ecommerce.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "shopping_session")
public class ShoppingSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float total;

    //mappedBy indica que la columna dada es propiedad de otra entidad
    @OneToMany(mappedBy = "shoppingSession")
    private List<CartItem> cartItems;


    //Que columna en la tabla ShoppingSession tiene la FK
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

}
