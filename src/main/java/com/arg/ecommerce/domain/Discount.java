package com.arg.ecommerce.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "discount")
public class Discount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "discount_percent")
    private float discountPercent;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
