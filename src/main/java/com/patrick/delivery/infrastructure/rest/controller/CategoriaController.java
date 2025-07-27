package com.patrick.delivery.infrastructure.rest.controller;

import com.patrick.delivery.infrastructure.rest.dto.categoria.CategoriaRequest;
import com.patrick.delivery.infrastructure.rest.dto.categoria.CategoriaResponse;
import com.patrick.delivery.infrastructure.rest.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "categoria")
@RequiredArgsConstructor
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Criar uma categoria",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<CategoriaResponse> salvar(@RequestBody @Valid CategoriaRequest request) {
        CategoriaResponse response = categoriaService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Listar todas as castegorias",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<List<CategoriaResponse>> listarTodos() {
        List<CategoriaResponse> responses = categoriaService.listar();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Buscar categoria por id",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<CategoriaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }
}
