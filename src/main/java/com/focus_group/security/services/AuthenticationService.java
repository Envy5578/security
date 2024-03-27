package com.focus_group.security.services;

import org.springframework.stereotype.Service;

import com.focus_group.security.dto.RegistrationRequest;
import com.focus_group.security.tokens.JwtTokenService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    
    public void registerAndGetToken(RegistrationRequest register) {
        userService.save(register);
        // sendMailVerification(register);
    }


    private void sendMailVerification(RegistrationRequest register) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendMailVerification'");
    }

}
