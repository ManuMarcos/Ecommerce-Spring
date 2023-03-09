package com.arg.ecommerce.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer idProduct;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotEmpty
    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private float price;

    @NotEmpty
    @Column(name = "image_link")
    private String imgLink;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Discount> discounts;












}
