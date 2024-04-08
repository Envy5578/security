package com.focus_group.security.exceptions;

import com.focus_group.security.enumType.ErrorCode;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private ErrorCode errorCode;

    public UserNotFoundException(ErrorCode errorType) {
        super(errorType.getMessage());
    }
}