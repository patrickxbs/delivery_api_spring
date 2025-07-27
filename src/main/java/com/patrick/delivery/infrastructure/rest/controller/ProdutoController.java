package com.patrick.delivery.infrastructure.rest.controller;

import com.patrick.delivery.infrastructure.rest.dto.produto.AlterarProdutoRequest;
import com.patrick.delivery.infrastructure.rest.dto.produto.ProdutoRequest;
import com.patrick.delivery.infrastructure.rest.dto.produto.ProdutoResponse;
import com.patrick.delivery.infrastructure.rest.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProdutoResponse> salvar(@RequestBody @Valid ProdutoRequest request) {
        ProdutoResponse response = produtoService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    public ResponseEntity<List<ProdutoResponse>> listar() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> alterar(@PathVariable Long id, @RequestBody AlterarProdutoRequest request) {
        produtoService.alterar(id, request);
        return ResponseEntity.noContent().build();
    }
}
