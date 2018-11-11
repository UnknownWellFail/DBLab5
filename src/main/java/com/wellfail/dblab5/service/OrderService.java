package com.wellfail.dblab5.service;

import com.wellfail.dblab5.entity.Order;
import com.wellfail.dblab5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    public void addOrder(Order order, Object o) {
        orderRepository.save(order);
    }

    public void removeOrder(Order order) {
        orderRepository.delete(order);
    }
}
