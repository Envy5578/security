package com.focus_group.security.controllers;

import com.focus_group.security.dto.NewPasswordRequest;
import com.focus_group.security.dto.ResetPasswordRequest;
import com.focus_group.security.services.PasswordResetService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication, Registration", description = "Authentication, Registration")
public class AuthenticationController {
    private final PasswordResetService passwordResetService;
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void resetPassword(@RequestParam("token") String resetToken, @RequestBody @Valid NewPasswordRequest request) {
//        passwordResetService.resetPassword(resetToken, request);
//    }
//    @Operation(summary = "Reset password")
//    @PostMapping("/password-reset")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void requestPasswordReset(@RequestBody @Valid ResetPasswordRequest request) {
//        passwordResetService.sendPasswordResetEmail(request);
//    }


}
