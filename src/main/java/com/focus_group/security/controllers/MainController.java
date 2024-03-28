package com.focus_group.security.controllers;

import com.focus_group.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RequestMapping("/secured")
@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService service;

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(service.getMe());
    }

}
