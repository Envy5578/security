package com.focus_group.security.tokens;

import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;


public class JwtTokenService implements TokenService {

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
