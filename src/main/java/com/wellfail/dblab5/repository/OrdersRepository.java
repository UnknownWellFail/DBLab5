package com.wellfail.dblab5.repository;

import com.wellfail.dblab5.entity.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Integer> {
}
