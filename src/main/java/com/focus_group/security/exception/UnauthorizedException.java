package com.focus_group.security.exception;
import org.springframework.security.core.AuthenticationException;

import com.focus_group.security.enumType.ErrorCode;

public class UnauthorizedException extends AuthenticationException{

    private ErrorCode errorCode;

    public UnauthorizedException(ErrorCode errorType) {
        super(errorType.getMessage());
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
    
    
    
}
