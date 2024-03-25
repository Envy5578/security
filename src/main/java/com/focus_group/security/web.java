package com.focus_group.security;

import org.springframework.lang.Nullable;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

public class web implements CorsConfigurationSource {

    @Override
    @Nullable
    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCorsConfiguration'");
    }
    
}
