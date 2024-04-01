package com.focus_group.security.controllers;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.focus_group.security.dto.NewPasswordRequest;
import com.focus_group.security.services.UserService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/secured")
@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService service;

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(service.getMe());
    }
    
    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody NewPasswordRequest request, Principal connectedUser) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }
    
}
