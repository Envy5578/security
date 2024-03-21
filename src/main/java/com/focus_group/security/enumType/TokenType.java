package com.focus_group.security.enumType;

public enum TokenType {
    RESET_TOKEN("RESET_TOKEN"),
    REFRESH_TOKEN("REFRESH_TOKEN");
    private final String tokenType;
    TokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    public String getTokenType() {
        return tokenType;
    }
}
