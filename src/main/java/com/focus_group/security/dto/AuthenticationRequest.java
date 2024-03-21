package com.focus_group.security.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request object for authentication")
public record AuthenticationRequest(
    
) {}
