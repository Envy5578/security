package com.focus_group.security.tokens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;


@RequiredArgsConstructor
public class JwtTokenService implements TokenService {
    private final JwtCore jwtCore;
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
