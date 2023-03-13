package com.arg.ecommerce.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ProductSizeKey implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "size_id")
    private Long sizeId;
}
