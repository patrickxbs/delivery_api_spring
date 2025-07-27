package com.patrick.delivery.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
@Log4j2
public class SecurityFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;

    private final AuthorizationService authorizationService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recoveryToken(request);

        if (token != null) {
            String email = jwtTokenService.getSubjectToken(token);

            UserDetails userDetails = authorizationService.loadUserByUsername(email);

            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
                log.info("authentication: {}", authentication);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }


        filterChain.doFilter(request, response);

    }

    private String recoveryToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null)
            return  null;

        return  authHeader.replace("Bearer ", "");
    }
}
