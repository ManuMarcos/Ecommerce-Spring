package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.OrderItem;

import java.util.List;

public interface OrderItemService {

    public List<OrderItem> listOrderItems();

    public void save(OrderItem orderItem);

    public void delete(OrderItem orderItem);

    public OrderItem findOrderItemById(OrderItem orderItem);

}
