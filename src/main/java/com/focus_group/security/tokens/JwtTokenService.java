package com.focus_group.security.tokens;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JwtTokenService {
    private final JwtCore jwtCore;


    public String extractUserIdFromJWT(String jwt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractUserIdFromJWT'");
    }

}

