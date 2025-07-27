package com.patrick.delivery.infrastructure.rest.controller;

import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import com.patrick.delivery.infrastructure.rest.dto.endereco.EnderecoRequest;
import com.patrick.delivery.infrastructure.rest.dto.endereco.EnderecoResponse;
import com.patrick.delivery.infrastructure.rest.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "endereco")
@RequiredArgsConstructor
@RestController
@RequestMapping("endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    @PreAuthorize("hasRole('CLIENTE')")
    @Operation(summary = "Salvar um novo endereço",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<EnderecoResponse> salvar(@RequestBody @Valid EnderecoRequest request,
                                                   @AuthenticationPrincipal UsuarioEntity usuario) {
        EnderecoResponse response = enderecoService.salvar(request,  usuario.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/usuario/{id}")
    @PreAuthorize("hasRole('ADMIN') OR (hasRole('CLIENTE') AND #id == authentication.principal.id)")
    @Operation(summary = "Listar endereços por usuario",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<List<EnderecoResponse>> listarEnderecoPorUsuario(@PathVariable Long id) {
        List<EnderecoResponse> responses = enderecoService.listarEnderecosPorUsuario(id);
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    @Operation(summary = "Desativar endereço",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<Void> desativar(@PathVariable Long id, @AuthenticationPrincipal UsuarioEntity usuario) {
        enderecoService.deletar(id, usuario.getId());
        return ResponseEntity.noContent().build();
    }
}