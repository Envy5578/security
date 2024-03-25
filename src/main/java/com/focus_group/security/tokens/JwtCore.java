package com.focus_group.security.tokens;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtCore implements Token {

    @Value("${testing.app.secret}")
    private String secret;
    @Value("${testing.app.accessTokenExpiration}")
    private int accessTokenExpiration;
    @Value("${testing.app.refreshTokenExpiration}")
    private int refreshTokenExpiration;
    private static final String AUTHORIZATION = "Authorization";

    public String generateAccessToken(String username) {
        
        return JWT.create()
                .withSubject(AUTHORIZATION)
                .withClaim("username", username)
                .withExpiresAt(new java.util.Date(System.currentTimeMillis() + accessTokenExpiration))
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }
    @Override
    public String getKey() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKey'");
    }

    @Override
    public long getKeyCreationTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKeyCreationTime'");
    }

    @Override
    public String getExtendedInformation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExtendedInformation'");
    }
    
}
