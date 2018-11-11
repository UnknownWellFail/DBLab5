package com.wellfail.dblab5.controller;

import com.wellfail.dblab5.entity.Developer;
import com.wellfail.dblab5.service.DeveloperService;
import com.wellfail.dblab5.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RequestMapping("/developers")
@Controller
public class DevelopersController {

    @Autowired
    private DeveloperService developerService;


    @Autowired
    private ProfileService profileService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getDevelopers(Model model) {
        model.addAttribute("developers", developerService.findAll());
        model.addAttribute("profiles", profileService.findAll());
        return "pages/developers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String add(
            @Valid @ModelAttribute("Developer") Developer developer,
            @RequestParam Map<String, String> form,
            BindingResult bindingResult,
            Model model
    ) throws Exception {
        if (bindingResult.hasErrors()) {

            Map<String, String> errorMap = ControllerUtil.getErrors(bindingResult);


            model.mergeAttributes(errorMap);
            model.addAttribute("developer", developer);
        } else {

            model.addAttribute("developer", null);
            developerService.saveDeveloper(developer, form);
        }
        model.addAttribute("profiles", profileService.findAll());
        Iterable<Developer> messages = developerService.findAll();
        model.addAttribute("developers", messages);
        return "pages/developers";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("remove/{developer}")
    public String removeDeveloper(
            @PathVariable Developer developer
    ) {
        developerService.removeDeveloper(developer);
        return "redirect:/developers";
    }

}
