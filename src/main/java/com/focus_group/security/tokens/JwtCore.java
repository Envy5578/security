package com.focus_group.security.tokens;

import org.springframework.security.core.token.Token;

public class JwtCore implements Token {

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
