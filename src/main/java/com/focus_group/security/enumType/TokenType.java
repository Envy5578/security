package com.focus_group.security.enumType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TokenType {
    //ДОПИСАТЬ ВРЕМЯ ДЛЯ ТОКЕНОВ
    RESET_TOKEN(5*60),
    REFRESH_TOKEN(7*50*60),
    RESET_PASSWORD_EMAIL(5*60);
    private final long tokenExpiration;
}
