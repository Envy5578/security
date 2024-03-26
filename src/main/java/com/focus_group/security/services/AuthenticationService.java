package com.focus_group.security.services;

import com.focus_group.security.tokens.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtTokenService jwtTokenService;

}
