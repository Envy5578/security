package com.focus_group.security.tokens;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
=======

>>>>>>> 9222cd58df43168e32f7f6bb2c1ce818d2688682
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

import com.focus_group.security.dto.AuthenticationResponse;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
<<<<<<< HEAD
public class JwtTokenService implements TokenService {
    private final JwtCore jwtCore;
=======
@Service
public class JwtTokenService implements TokenService {
    // private final JwtCore jwtCore;
    public AuthenticationResponse generateAccessToken(String username) {
        return new AuthenticationResponse();
    }
>>>>>>> 9222cd58df43168e32f7f6bb2c1ce818d2688682
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
