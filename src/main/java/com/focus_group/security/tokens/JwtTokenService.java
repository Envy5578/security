package com.focus_group.security.tokens;


import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

import com.focus_group.security.dto.AuthenticationResponse;



@Service
public class JwtTokenService implements TokenService {
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
