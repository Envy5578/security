package com.focus_group.security.tokens;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.focus_group.security.enumType.ErrorCode;
import com.focus_group.security.exception.UnauthorizedException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final JwtTokenService tokenService;
    private static final List<String> ALLOWED_PATHS = List.of(
            "/api/v1/auth",
            "api/v1/test",
            "/v2/api-docs",
            "/actuator",
            "/error",
            "/v3/api-docs",
            "/swagger-resources",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui",
            "/webjars",
            "/swagger-ui.html",
            "/ws/**",
            "/ws/info",
            "/ws"
    );

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                if (isRequestAllowedWithoutAuthentication(request)) {
                    filterChain.doFilter(request, response);
                    return;
                }
                try {
            String jwt = extractJwtFromRequest(request);
//            String userId = tokenService.extractUserIdFromJWT(jwt);
//            authenticateUserIfNecessary(userId, jwt, request);
        } catch (UnauthorizedException e) {
            log.error("Authentication error: {}", e.getMessage());
            sendErrorResponse(e, response, request);
            return;
        } catch (JWTVerificationException e){
            log.error("Authentication error: {}", e.getMessage());
            sendErrorResponse(new UnauthorizedException(ErrorCode.INVALID_ACCESS_TOKEN), response, request);
            return;
        }

        filterChain.doFilter(request, response);
    }

    
    private void sendErrorResponse(UnauthorizedException e, HttpServletResponse response, HttpServletRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendErrorResponse'");
    }


    private boolean isRequestAllowedWithoutAuthentication(HttpServletRequest request) {
        String requestPath = request.getServletPath();
        return ALLOWED_PATHS.stream().anyMatch(requestPath::contains);
    }
    
    private void authenticateUserIfNecessary(String userId, String jwt, HttpServletRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticateUserIfNecessary'");
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extractJwtFromRequest'");
    }
    

    

}
