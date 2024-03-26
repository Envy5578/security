package com.focus_group.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RequestMapping("/secured")
@RestController
public class MainController {
    @GetMapping("/user")
    public String getUser(Principal principal) {
        return principal.getName();
    }

}
