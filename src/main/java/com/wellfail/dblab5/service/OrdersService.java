package com.wellfail.dblab5.service;

import com.wellfail.dblab5.entity.Orders;
import com.wellfail.dblab5.repository.OrderRepository;
import com.wellfail.dblab5.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {


    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAll() {
        return (List<Orders>) ordersRepository.findAll();
    }
}
