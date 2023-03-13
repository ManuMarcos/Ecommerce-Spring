package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.OrderItemDao;
import com.arg.ecommerce.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemDao orderItemDao;


    @Transactional(readOnly = true)
    @Override
    public List<OrderItem> listOrderItems() {
        return orderItemDao.findAll();
    }

    @Transactional
    @Override
    public void save(OrderItem orderItem) {
        orderItemDao.save(orderItem);
    }

    @Transactional
    @Override
    public void delete(OrderItem orderItem) {
        orderItemDao.delete(orderItem);
    }

    @Transactional(readOnly = true)
    @Override
    public OrderItem findOrderItemById(OrderItem orderItem) {
        return orderItemDao.findById(orderItem.getId()).orElse(null);
    }
}
