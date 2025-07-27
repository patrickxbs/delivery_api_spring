package com.patrick.delivery.infrastructure.rest.controller;

import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import com.patrick.delivery.infrastructure.rest.dto.login.LoginRequest;
import com.patrick.delivery.infrastructure.rest.dto.login.LoginResponse;
import com.patrick.delivery.infrastructure.security.JwtTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "login")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    @PostMapping("/login")
    @Operation(summary = "Gerar um token JWT")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken
                (request.email(), request.senha());

        var auth = this.authenticationManager.authenticate(login);
        var token = this.jwtTokenService.generateToken((UsuarioEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
