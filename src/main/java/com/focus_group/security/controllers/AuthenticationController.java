package com.focus_group.security.controllers;

import com.focus_group.security.PasswordResetEmailRequest;
import com.focus_group.security.dto.*;
import com.focus_group.security.services.MailService;
import com.focus_group.security.tokens.JwtTokenService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.focus_group.security.services.AuthenticationService;
import com.focus_group.security.services.PasswordResetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication, Registration", description = "Authentication, Registration")
public class AuthenticationController {
    private final AuthenticationService service;
    private final PasswordResetService passwordResetService;
    private final MailService emailService;

    @Operation(summary = "Registration")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegistrationRequest register) {
        service.register(register);
    }

    @Operation(summary = "Sign In")
    @PostMapping("/sign-in")
    public AuthenticationResponse signIn(@RequestBody @Valid AuthenticationRequest register, HttpServletRequest request) {
        return service.signIn(register, request);
    }


    //ПОЛУЧЕНИЕ ПАРОЛЯ С ССЫЛКИ НА ЕМЭЙЛ
    @Operation(summary = "Reset password for email")
    @PostMapping("/reset-password-email")
    public ResponseEntity<?> resetPasswordForEmailToken(String resetToken) {
        return passwordResetService.resetPasswordForEmailToken(resetToken);
    }
    
    //СМЕНА ПАРОЛЯ С ССЫЛКИ НА ЕМЭЙЛ
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody @Valid ResetPassword password, HttpServletRequest request) {
        return service.resetPassword(password, request);
    }

    @PostMapping(value = "/password-reset")
    @Operation(summary = "Reset password for email")
    public @ResponseBody // возвращаемое значение должно быть сериализовано непосредственно в тело HTTP ответа.
    ResponseEntity<String> resetPassword(@RequestBody PasswordResetEmailRequest request) {
        try {
            emailService.sendEmailToUser(request.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to send email for password reset.");
        }

        return ResponseEntity.ok("Please check your inbox for password reset instructions.");
    }

    @PostMapping("/verify")
    public @ResponseBody // возвращаемое значение должно быть сериализовано непосредственно в тело HTTP ответа.
    ResponseEntity<String> sendEmailVerification(@RequestBody PasswordResetEmailRequest request) {
        return emailService.sendEmailVerification(request.getEmail());
    }

//    @PostMapping("/refresh-token")
//    public @ResponseBody // возвращаемое значение должно быть сериализовано непосредственно в тело HTTP ответа.
//    ResponseEntity<String> refreshToken( @RequestBody String email, HttpServletRequest request) {
//        return jwtTokenService.generateRefreshToken( email,  request);
//    } // Нужно додалать
} // пока отправки не дописаны но в будущем сделаю