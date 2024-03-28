package com.focus_group.security.enumType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum RoleType {
    USER("USER");
    private final String roleType;

}
