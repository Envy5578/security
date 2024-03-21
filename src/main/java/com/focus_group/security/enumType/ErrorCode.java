package com.focus_group.security.enumType;

public enum ErrorCode {
        UNAUTHORIZED_ACCESS("Unauthorized access"),
        INVALID_CREDENTIALS("Invalid credentials"),
        EXPIRED_TOKEN("Expired token"),
        INVALID_ACCESS_TOKEN("Invalid access token");

        private final String message;

        ErrorCode(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
