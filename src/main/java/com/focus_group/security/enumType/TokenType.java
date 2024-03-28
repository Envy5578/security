package com.focus_group.security.enumType;

public enum TokenType {
    RESET_TOKEN(5*60),
    REFRESH_TOKEN(7*50*60),
    RESET_PASSWORD_EMAIL(5*60);

    private final long tokenType;

    TokenType(long tokenType) {
        this.tokenType = tokenType;
    }

    public Long getTokenType() {
        return tokenType;
    }
    // public String getTokenType(String tokenType) {
    //     return tokenType;
    // }
}
