package com.wellfail.dblab5.repository;

import com.wellfail.dblab5.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
