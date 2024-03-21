package com.focus_group.security.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/secured")
@RestController
public class MainController {
    @GetMapping("/user")
    public String getUser(Principal principal) {
        return principal.getName();
    }
    
}
