package com.patrick.delivery.infrastructure.rest.controller;

import com.patrick.delivery.infrastructure.rest.dto.usuario.AlterarDadosUsuarioRequest;
import com.patrick.delivery.infrastructure.rest.dto.usuario.AlterarSenhaUsuarioRequest;
import com.patrick.delivery.infrastructure.rest.dto.usuario.UsuarioRequest;
import com.patrick.delivery.infrastructure.rest.dto.usuario.UsuarioResponse;
import com.patrick.delivery.infrastructure.rest.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("usuario")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cliente/cadastrar")
    public ResponseEntity<UsuarioResponse> cadastrar(@Valid @RequestBody UsuarioRequest request) {
        UsuarioResponse response = usuarioService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UsuarioResponse>> listarTodos() {
        List<UsuarioResponse> responses = usuarioService.listarUsuarios();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') OR #id == authentication.principal.id")
    public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable Long id) {
        UsuarioResponse response = usuarioService.buscarUsuario(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/alterar-senha/{id}")
    @PreAuthorize("hasRole('ADMIN') OR (hasRole('CLIENTE') AND #id == authentication.principal.id)")
    public ResponseEntity<Void> alterarSenha(@PathVariable Long id, @Valid @RequestBody AlterarSenhaUsuarioRequest resquest) {
        usuarioService.alterarSenha(id, resquest);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    @PreAuthorize("hasRole('ADMIN') OR (hasRole('CLIENTE') AND #id == authentication.principal.id)")
    public ResponseEntity<Void> alterarDados(@PathVariable Long id, @Valid @RequestBody AlterarDadosUsuarioRequest request) {
        usuarioService.alterarDados(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') OR (hasRole('CLIENTE') AND #id == authentication.principal.id)")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
