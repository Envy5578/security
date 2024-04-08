package com.focus_group.security;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.focus_group.security.controllers.AuthenticationController;

@WebMvcTest(controllers = AuthenticationController.class)
class SecurityApplicationTests {

}
