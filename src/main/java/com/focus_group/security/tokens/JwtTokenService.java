package com.focus_group.security.tokens;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.focus_group.security.entitys.UserEntity;
import org.flywaydb.core.internal.parser.TokenType;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

import com.focus_group.security.dto.AuthenticationResponse;

import java.security.Key;
import java.util.Date;

import static com.focus_group.security.enumType.TokenType.REFRESH_TOKEN;
import static com.focus_group.security.enumType.TokenType.RESET_PASSWORD_EMAIL;


@Service
public class JwtTokenService implements TokenService {
    private final long expirationTimeInMs = 3600000; // Время истечения токена (1 час)
    // private final JwtCore jwtCore;
    public AuthenticationResponse generateAccessToken(String username) {
//        return new AuthenticationResponse(username);
        return null;
    }

    @Override
    public Token allocateToken(String extendedInformation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allocateToken'");
    }

    @Override
    public Token verifyToken(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyToken'");
    }

    public String extractUserIdFromJWT(String jwt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractUserIdFromJWT'");
    }

}
