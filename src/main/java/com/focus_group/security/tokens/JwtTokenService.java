package com.focus_group.security.tokens;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class JwtTokenService {
    private final JwtCore jwtCore;


    public String extractUserEmailFromJWT(String jwt) {
        return jwtCore.getUserEmailFromJwt(jwt);
    }


    public boolean validateToken(String jwt) {
        return jwtCore.validateToken(jwt);
    }

}

