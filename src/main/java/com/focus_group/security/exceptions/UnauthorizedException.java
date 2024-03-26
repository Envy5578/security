package com.focus_group.security.exceptions;

import com.focus_group.security.enumType.ErrorCode;
import org.springframework.security.core.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {

    private ErrorCode errorCode;

    public UnauthorizedException(ErrorCode errorType) {
        super(errorType.getMessage());
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }


}
