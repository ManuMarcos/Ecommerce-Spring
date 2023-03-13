package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.OrderDetailDao;
import com.arg.ecommerce.domain.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    private OrderDetailDao orderDetailDao;


    @Transactional(readOnly = true)
    @Override
    public List<OrderDetail> listOrderDetails() {
        return orderDetailDao.findAll();
    }

    @Transactional
    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailDao.save(orderDetail);
    }

    @Transactional
    @Override
    public void delete(OrderDetail orderDetail) {
        orderDetailDao.delete(orderDetail);
    }

    @Transactional(readOnly = true)
    @Override
    public OrderDetail findOrderDetailById(OrderDetail orderDetail) {
        return orderDetailDao.findById(orderDetail.getId()).orElse(null);
    }
}
