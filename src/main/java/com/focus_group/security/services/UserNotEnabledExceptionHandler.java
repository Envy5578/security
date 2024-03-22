package com.focus_group.security.services;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class UserNotEnabledExceptionHandler implements AuthenticationEntryPoint {
    private final ObjectMapper mapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException{
        // log.error(e);

        // ErrorDTO errorDTO = ErrorDTO.builder()
        //         .message(ErrorCode.EMAIL_NOT_VERIFIED.getMessage())
        //         .errorCode(ErrorCode.EMAIL_NOT_VERIFIED.name())
        //         .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
        //         .statusCode(HttpStatus.UNAUTHORIZED.value())
        //         .path(request.getRequestURI())
        //         .timestamp(LocalDateTime.now())
        //         .build();
        // response.setStatus(HttpStatus.UNAUTHORIZED.value());
        // response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // response.getWriter().write(mapper.writeValueAsString(errorDTO));
    }
    
}
