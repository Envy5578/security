package com.focus_group.security.tokens;


import org.springframework.stereotype.Service;

import com.focus_group.security.dto.AuthenticationResponse;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class JwtTokenService{
    private final JwtCore jwtCore;
    public AuthenticationResponse generateAccessToken(String username) {
        return new AuthenticationResponse(username, username, null, username);
    }



    public String extractUserIdFromJWT(String jwt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractUserIdFromJWT'");
    }
    
}

