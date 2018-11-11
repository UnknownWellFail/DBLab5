package com.wellfail.dblab5.controller;

import com.wellfail.dblab5.entity.Client;
import com.wellfail.dblab5.entity.Orders;
import com.wellfail.dblab5.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/forders")
@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getOrders(
            Model model
    ){
        model.addAttribute("orders",ordersService.findAll());
        return "/pages/forders";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("remove/{orders}")
    public String removeDeveloper(
            @PathVariable Orders orders
    ) {
        ordersService.removeOrders(orders);
        return "redirect:/forders";
    }

}
