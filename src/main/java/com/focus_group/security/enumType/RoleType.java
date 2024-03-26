package com.focus_group.security.enumType;

public enum RoleType {
    USER("USER");
    private final String roleType;

    RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
}
