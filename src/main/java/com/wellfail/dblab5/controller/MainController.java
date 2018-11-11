package com.wellfail.dblab5.controller;

import com.wellfail.dblab5.entity.Orders;
import com.wellfail.dblab5.service.ClientService;
import com.wellfail.dblab5.service.DeveloperService;
import com.wellfail.dblab5.service.OrderService;
import com.wellfail.dblab5.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {


    @Autowired
    private ClientService clientService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private DeveloperService developerService;


    @Autowired
    private OrderService orderService;


    @GetMapping("/")
    public String greting() {
        return "index";
    }
}
