package com.focus_group.security.properties;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationProperties {
    private final List<String> allowedOrigins = List.of(
            "http://*.example.com/*" // Добавить тут адрес клиента
    );

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }
}
