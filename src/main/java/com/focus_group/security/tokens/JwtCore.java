package com.focus_group.security.tokens;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.focus_group.security.entities.UserEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtCore {

    @Value("${testing.app.secret}")
    private String secret;
    @Value("${testing.app.accessTokenExpiration}")
    private int accessTokenExpiration;
    @Value("${testing.app.refreshTokenExpiration}")
    private int refreshTokenExpiration;
    private static final String AUTHORIZATION = "Authorization";

    public String generateAccessToken(String email) {

        return JWT.create()
                .withSubject(AUTHORIZATION)
                .withClaim("email", email)
                .withExpiresAt(new java.util.Date(System.currentTimeMillis() + accessTokenExpiration))
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }

    public String generateRefreshToken(Authentication authentication) {
        UserEntity userPrincipal = (UserEntity) authentication.getPrincipal();
        return JWT.create()
                .withSubject(AUTHORIZATION)
                .withClaim("firstName", userPrincipal.getFirstName())
                .withClaim("lastName", userPrincipal.getLastName())
                .withClaim("email", userPrincipal.getEmail())
                .withExpiresAt(new java.util.Date(System.currentTimeMillis() + accessTokenExpiration))
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }

    public String getUserEmailFromJwt(String jwt) {
        return JWT.require(Algorithm.HMAC512(secret.getBytes()))
                .build()
                .verify(jwt)
                .getClaim("email")
                .asString();
    }
    public boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret.getBytes()))
            .withSubject(AUTHORIZATION)
            .build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
