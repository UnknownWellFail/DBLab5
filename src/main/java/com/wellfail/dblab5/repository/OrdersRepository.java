package com.wellfail.dblab5.repository;

import com.wellfail.dblab5.entity.Client;
import com.wellfail.dblab5.entity.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders,Integer> {

    List<Orders> findByOrderClient(Client client);
}
