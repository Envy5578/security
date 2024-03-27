package com.focus_group.security.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.focus_group.security.services.PasswordResetService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication, Registration", description = "Authentication, Registration")
public class AuthenticationController {
    private final PasswordResetService passwordResetService;
    



}
