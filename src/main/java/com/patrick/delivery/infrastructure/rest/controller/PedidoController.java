package com.patrick.delivery.infrastructure.rest.controller;

import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import com.patrick.delivery.infrastructure.rest.dto.pedido.AlterarStatusPedidoRequest;
import com.patrick.delivery.infrastructure.rest.dto.pedido.PedidoRequest;
import com.patrick.delivery.infrastructure.rest.dto.pedido.PedidoResponse;
import com.patrick.delivery.infrastructure.rest.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    @PreAuthorize("hasRole('CLIENTE')")
    public ResponseEntity<PedidoResponse> salvar(@RequestBody @Valid PedidoRequest request) {
        PedidoResponse response = pedidoService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable Long id) {
        PedidoResponse response = pedidoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/usuario/{id}")
    @PreAuthorize("hasRole('ADMIN') OR (hasRole('CLIENTE') AND #id == authentication.principal.id)")
    public ResponseEntity<List<PedidoResponse>> listarPedidosPorUsuarioId(@PathVariable Long id) {
        List<PedidoResponse> responses = pedidoService.listarPedidosPorClienteById(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PedidoResponse>> listarPedidos() {
        List<PedidoResponse> responses = pedidoService.listarPedidos();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("alterarstatus/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> alterarStatus(@PathVariable Long id, @RequestBody AlterarStatusPedidoRequest status) {
        pedidoService.alterarStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cancelar/{id}")
    @PreAuthorize("hasRole('CLIENTE')")
    public ResponseEntity<Void> cancelar(@PathVariable Long id, @AuthenticationPrincipal UsuarioEntity usuario) {
        pedidoService.cancelar(id, usuario.getId());
        return ResponseEntity.noContent().build();
    }
}
