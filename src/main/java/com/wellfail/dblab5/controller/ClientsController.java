package com.wellfail.dblab5.controller;

import com.wellfail.dblab5.entity.Client;
import com.wellfail.dblab5.entity.Developer;
import com.wellfail.dblab5.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RequestMapping("/clients")
@Controller
public class ClientsController {


    @Autowired
    private ClientService clientService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getClients(Model model){
        model.addAttribute("clients", clientService.findAll());
        return "pages/clients";
    }

    @PostMapping
    public String add(
            @Valid @ModelAttribute("Client") Client client,
            BindingResult bindingResult,
            Model model
    ) throws Exception {
        if (bindingResult.hasErrors()) {

            Map<String, String> errorMap = ControllerUtil.getErrors(bindingResult);


            model.mergeAttributes(errorMap);
            model.addAttribute("client", client);
        } else {

            model.addAttribute("client", null);
            clientService.saveClient(client,null);
        }
        Iterable<Client> messages = clientService.findAll();
        model.addAttribute("clients", messages);
        return "pages/clients";
    }
}
