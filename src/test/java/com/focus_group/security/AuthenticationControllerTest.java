package com.focus_group.security;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.focus_group.security.controllers.AuthenticationController;
import com.focus_group.security.dto.AuthenticationRequest;
import com.focus_group.security.dto.AuthenticationResponse;
import com.focus_group.security.dto.RegistrationRequest;
import com.focus_group.security.enumType.TokenType;
import com.focus_group.security.services.AuthenticationService;
import com.focus_group.security.services.PasswordResetService;
import com.focus_group.security.tokens.JwtCore;

import jakarta.servlet.http.HttpServletRequest;

@WebMvcTest(AuthenticationController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private PasswordResetService passwordResetService;

    @MockBean
    private JwtCore jwtCore;

    @MockBean
    private TokenType tokenType;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testRegister() throws Exception {
        RegistrationRequest request = new RegistrationRequest("testFirstName", "testLastName", "testEmail", "testPassword" );
        // Установите данные запроса

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        // Добавьте утверждения для вызова службы, если необходимо
    }

    @Test
    public void testSignIn() throws Exception {
        AuthenticationRequest request = new AuthenticationRequest( "testEmail", "testPassword" );
        // Установите данные запроса

        AuthenticationResponse response = new AuthenticationResponse( TokenType.REFRESH_TOKEN.name() , jwtCore.generateAccessToken( "testEmail", TokenType.ACCESS_TOKEN ), 30, jwtCore.generateRefreshToken( "testEmail", TokenType.REFRESH_TOKEN ));
        // Установите данные ответа

        when(authenticationService.signIn(any(AuthenticationRequest.class), any(HttpServletRequest.class)))
                .thenReturn(response);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        AuthenticationResponse actualResponse = objectMapper.readValue(content, AuthenticationResponse.class);

        assertThat(actualResponse).isEqualTo(response);
    }

    // @Test
    // public void testResetPasswordForEmailToken() throws Exception {
    //     String resetToken = jwtCore.generateResetToken("testEmail", TokenType.REFRESH_TOKEN);

    //     // ResponseEntity<?> responseEntity = new ResponseEntity<>(HttpStatus.OK);
    //     when(passwordResetService.resetPasswordForEmailToken(resetToken))
    //             .thenReturn(ResponseEntity.ok().build());

    //     MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/auth/reset-password-email/{resetToken}", resetToken))
    //             .andExpect(MockMvcResultMatchers.status().isOk())
    //             .andReturn();

    //     String content = result.getResponse().getContentAsString();
    //     ResponseEntity<?> actualResponseEntity = objectMapper.readValue(content, ResponseEntity.class);

    //     assertThat(actualResponseEntity).isEqualTo(ResponseEntity.ok().build());
    // }

    // @Test
    // public void testResetPassword() throws Exception {
    //     ResetPassword request = new ResetPassword( "testPassword", "testPassword" );
    //     // Установите данные запроса

    //     // ResponseEntity<?> responseEntity = new ResponseEntity<>(HttpStatus.OK);
    //     when(authenticationService.resetPassword(any(ResetPassword.class), any(HttpServletRequest.class)))
    //             .thenReturn(ResponseEntity.ok().build());

    //     MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/reset-password")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(request)))
    //             .andExpect(MockMvcResultMatchers.status().isOk())
    //             .andReturn();

    //     String content = result.getResponse().getContentAsString();
    //     ResponseEntity<?> actualResponseEntity = objectMapper.readValue(content, ResponseEntity.class);

    //     assertThat(actualResponseEntity).isEqualTo(ResponseEntity.ok().build());
    // }
}