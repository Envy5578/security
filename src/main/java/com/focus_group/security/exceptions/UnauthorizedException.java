package com.focus_group.security.exceptions;

import com.focus_group.security.enumType.ErrorCode;
import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

@Getter
public class UnauthorizedException extends AuthenticationException {

    private ErrorCode errorCode;

    public UnauthorizedException(ErrorCode errorType) {
        super(errorType.getMessage());
    }


}
