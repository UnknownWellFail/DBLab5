package com.wellfail.dblab5.controller;

import com.wellfail.dblab5.entity.Order;
import com.wellfail.dblab5.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RequestMapping("/orders")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "pages/orders";
    }

    @PostMapping
    public String add(
            @Valid @ModelAttribute("Order") Order order,
            BindingResult bindingResult,
            Model model
    ) throws Exception {
        if (bindingResult.hasErrors()) {

            Map<String, String> errorMap = ControllerUtil.getErrors(bindingResult);


            model.mergeAttributes(errorMap);
            model.addAttribute("order", order);
        } else {

            model.addAttribute("order", null);
            orderService.addOrder(order, null);
        }
        Iterable<Order> messages = orderService.findAll();
        model.addAttribute("orders", messages);
        return "pages/orders";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("remove/{order}")
    public String removeDeveloper(
            @PathVariable Order order
    ) {
        orderService.removeOrder(order);
        return "redirect:/orders";
    }
}
