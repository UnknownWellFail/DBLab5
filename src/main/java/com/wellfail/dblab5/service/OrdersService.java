package com.wellfail.dblab5.service;

import com.wellfail.dblab5.entity.Client;
import com.wellfail.dblab5.entity.Order;
import com.wellfail.dblab5.entity.Orders;
import com.wellfail.dblab5.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {


    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAll() {
        return (List<Orders>) ordersRepository.findAll();
    }


    public List<Order> findByClientId(Client client) {
        List<Orders> orders = ordersRepository.findByOrderClient(client);
        List<Order> result = new ArrayList<>();
        for (Orders order : orders) {
            result.add(order.getOrder());
        }
        return result;
    }

    public void removeOrders(Orders orders) {
        ordersRepository.delete(orders);
    }

    public void addOrders(Orders orders) {
        ordersRepository.save(orders);
    }
}
