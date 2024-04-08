package com.focus_group.security.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorDTO(
        String message,
        String errorCode,
        String error,
        Integer statusCode,
        String path,
        LocalDateTime timestamp
) {
}
