package com.focus_group.security.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.focus_group.security.dto.RegistrationRequest;
import com.focus_group.security.services.AuthenticationService;
import com.focus_group.security.services.PasswordResetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication, Registration", description = "Authentication, Registration")
public class AuthenticationController {
    private final PasswordResetService passwordResetService;
    private final AuthenticationService service;
    
    @Operation(summary = "Registration")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegistrationRequest register) {
        service.registerAndGetToken(register);
    }


}
