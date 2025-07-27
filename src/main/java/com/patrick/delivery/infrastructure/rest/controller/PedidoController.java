package com.patrick.delivery.infrastructure.rest.controller;

import com.patrick.delivery.infrastructure.entity.UsuarioEntity;
import com.patrick.delivery.infrastructure.rest.dto.pedido.AlterarStatusPedidoRequest;
import com.patrick.delivery.infrastructure.rest.dto.pedido.PedidoRequest;
import com.patrick.delivery.infrastructure.rest.dto.pedido.PedidoResponse;
import com.patrick.delivery.infrastructure.rest.service.PedidoService;
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

@Tag(name = "pedido")
@RequiredArgsConstructor
@RestController
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    @PreAuthorize("hasRole('CLIENTE')")
    @Operation(summary = "Criar uma novo pedido",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<PedidoResponse> salvar(@RequestBody @Valid PedidoRequest request) {
        PedidoResponse response = pedidoService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Buscar pedido por id",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable Long id) {
        PedidoResponse response = pedidoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/usuario/{id}")
    @PreAuthorize("hasRole('ADMIN') OR (hasRole('CLIENTE') AND #id == authentication.principal.id)")
    @Operation(summary = "Listar pedidos por usuario",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<List<PedidoResponse>> listarPedidosPorUsuarioId(@PathVariable Long id) {
        List<PedidoResponse> responses = pedidoService.listarPedidosPorClienteById(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Listar todos pedidos",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<List<PedidoResponse>> listarPedidos() {
        List<PedidoResponse> responses = pedidoService.listarPedidos();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("alterarstatus/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Alterar status do pedido",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<Void> alterarStatus(@PathVariable Long id, @RequestBody AlterarStatusPedidoRequest status) {
        pedidoService.alterarStatus(id, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cancelar/{id}")
    @PreAuthorize("hasRole('CLIENTE')")
    @Operation(summary = "Cancelar pedido",
            security = @SecurityRequirement(name = "security"))
    public ResponseEntity<Void> cancelar(@PathVariable Long id, @AuthenticationPrincipal UsuarioEntity usuario) {
        pedidoService.cancelar(id, usuario.getId());
        return ResponseEntity.noContent().build();
    }
}
