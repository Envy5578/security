package com.focus_group.security.services;

import org.springframework.stereotype.Service;

import com.focus_group.security.tokens.JwtTokenService;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    
}
