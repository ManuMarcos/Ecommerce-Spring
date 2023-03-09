package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderDetailService {

    public List<OrderDetail> listOrderDetails();

    public void save(OrderDetail orderDetail);

    public void delete(OrderDetail orderDetail);

    public OrderDetail findOrderDetailById(OrderDetail orderDetail);
}
