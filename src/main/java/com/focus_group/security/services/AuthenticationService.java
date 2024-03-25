package com.focus_group.security.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.focus_group.security.services.UserService;
import com.focus_group.security.services.MailService;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final MailService mailService;
    
}
