package com.focus_group.security.tokens;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.focus_group.security.entitys.UserEntity;
import org.flywaydb.core.internal.parser.TokenType;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.security.Key;
import java.util.Date;

import static com.focus_group.security.enumType.TokenType.REFRESH_TOKEN;
import static com.focus_group.security.enumType.TokenType.RESET_PASSWORD_EMAIL;


@Service
@RequiredArgsConstructor
public class JwtTokenService{
    private final JwtCore jwtCore;




    public String extractUserIdFromJWT(String jwt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractUserIdFromJWT'");
    }

}

