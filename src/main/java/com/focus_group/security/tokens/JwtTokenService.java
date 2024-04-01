package com.focus_group.security.tokens;


import org.springframework.stereotype.Service;

import com.focus_group.security.enumType.TokenType;

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

    public String generateResetToken(String email, TokenType tokenType) {
        return jwtCore.generateResetToken(email, tokenType);
    }
    public String generateAccessToken(String email, TokenType tokenType) {
        return jwtCore.generateAccessToken(email, tokenType);
    }
    public String generateRefreshToken(String email, TokenType tokenType) {
        return jwtCore.generateRefreshToken(email, tokenType);
    }
}

