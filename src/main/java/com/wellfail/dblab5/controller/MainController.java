package com.wellfail.dblab5.controller;

import com.wellfail.dblab5.entity.Client;
import com.wellfail.dblab5.entity.Order;
import com.wellfail.dblab5.entity.Orders;
import com.wellfail.dblab5.entity.User;
import com.wellfail.dblab5.service.ClientService;
import com.wellfail.dblab5.service.OrderService;
import com.wellfail.dblab5.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

@Controller
public class MainController {


    @Autowired
    private ClientService clientService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/")
    public String greting() {
        return "index";
    }

    @GetMapping("/start")
    public String start(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        Client client = clientService.getClientByEmail(user.getEmail());
        model.addAttribute("client", client);
        return "start";
    }

    @PostMapping("/start")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid @ModelAttribute("Client") Client client,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = ControllerUtil.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute("client", client);
        } else {
            client.setEmail(user.getEmail());
            model.addAttribute("client", null);
            clientService.saveClient(client, null);
        }
        Iterable<Client> messages = clientService.findAll();
        model.addAttribute("clients", messages);
        return "redirect:/createOrder";
    }

    @GetMapping("/createOrder")
    public String getOrders(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("orders", ordersService.findByClientId(clientService.getClientByEmail(user.getEmail())));
        return "createOrders";
    }

    @PostMapping("/createOrder")
    public String addOrder(
            @AuthenticationPrincipal User user,
            @Valid Order order,
            Model model
    ) {
        Client client = clientService.getClientByEmail(user.getEmail());

        orderService.addOrder(order, null);
        Orders orders = new Orders(new Date(), client, null, order);
        ordersService.addOrders(orders);
        model.addAttribute("orders", ordersService.findByClientId(client));
        return "createOrders";
    }

}
