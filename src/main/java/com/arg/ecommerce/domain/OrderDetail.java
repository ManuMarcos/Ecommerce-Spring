package com.arg.ecommerce.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_details")
    private Integer idOrderDetail;

    private float total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "orderDetail", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PaymentDetail paymentDetail;

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

}
