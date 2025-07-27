package com.patrick.delivery.infrastructure.security;

import com.patrick.delivery.core.usecase.usuario.BuscarUsuarioUseCase;
import com.patrick.delivery.infrastructure.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorizationService implements UserDetailsService {

    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buscarUsuarioUseCase.buscarPorEmail(username).map(UsuarioMapper::toEntitySemEndereco)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    }
}
