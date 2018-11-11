package com.wellfail.dblab5.controller;

import com.wellfail.dblab5.entity.Developer;
import com.wellfail.dblab5.entity.Profile;
import com.wellfail.dblab5.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/profiles")
@Controller
public class ProfilesController {

    @Autowired
    private ProfileService profileService;


    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getAllProfiles(
            Model model
    ) {
        model.addAttribute("profiles", profileService.findAll());
        return "/pages/profiles";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String addProfile(
            @Valid Profile profile
    ) {
        profileService.addProfile(profile);
        return "redirect:/profiles";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("remove/{profile}")
    public String removeDeveloper(
            @PathVariable Profile profile
    ) {
        profileService.removeProfile(profile);
        return "redirect:/profiles";
    }

}
