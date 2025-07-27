package com.patrick.delivery.core.usecase.usuario.impl;

import com.patrick.delivery.gateway.usuario.CriptografarSenhaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CriptografarSenhaImpl implements CriptografarSenhaGateway {

    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean verificar(String senha, String senhaCriptografada) {
        return passwordEncoder.matches(senha, senhaCriptografada);
    }

    @Override
    public String criptografar(String senha) {
        return passwordEncoder.encode(senha);
    }
}
