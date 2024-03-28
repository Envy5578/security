package com.focus_group.security.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus_group.security.dto.AuthenticationRequest;
import com.focus_group.security.dto.AuthenticationResponse;
import com.focus_group.security.dto.RegistrationRequest;
import com.focus_group.security.entities.UserEntity;
import com.focus_group.security.enumType.TokenType;
import com.focus_group.security.repositories.UserRepository;
import com.focus_group.security.tokens.JwtTokenService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AuthenticationService {
    public static final int ACCESS_TOKEN_EXPIRES_IN_MINUTES = 30;
    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    
    public void register(RegistrationRequest register) {
        userService.save(register);
        // sendMailVerification(register);
    }


    private void sendMailVerification(RegistrationRequest register) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendMailVerification'");
    }


    public ResponseEntity<?> signIn(@Valid AuthenticationRequest register, HttpServletRequest request) {
        Authentication authentication = null;
        UserEntity user = userService.findByEmail(register.email()).orElseThrow(()-> new RuntimeException("User not found"));
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(register.email(), register.password()));
            }catch (BadCredentialsException e) {
                return new ResponseEntity("Bad credentials", HttpStatus.UNAUTHORIZED);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtTokenService.generateAccessToken(register.email());
        String refreshToken = jwtTokenService.generateRefreshToken(user, TokenType.REFRESH_TOKEN);
        return ResponseEntity.ok(new AuthenticationResponse(TokenType.REFRESH_TOKEN.name() , accessToken, ACCESS_TOKEN_EXPIRES_IN_MINUTES, refreshToken));
    }
}
