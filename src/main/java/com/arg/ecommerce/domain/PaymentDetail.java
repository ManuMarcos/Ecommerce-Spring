package com.arg.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "payment_detail")
public class PaymentDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_detail")
    private Integer idPaymentDetail;

    private float amount;

    private String provider;

    private String status;

    //Que columna en la tabla Payment Detail tiene la FK
    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderDetail orderDetail;

}
