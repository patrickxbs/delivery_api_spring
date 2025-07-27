package com.patrick.delivery.infrastructure.entity;

import com.patrick.delivery.enuns.StatusPedido;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "data_entregue")
    private LocalDateTime dataEntregue;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pedido")
    private StatusPedido statusPedido;

    private String descricao;

    @Column(name = "preco_total")
    private BigDecimal precoTotal;

    @OneToMany(mappedBy = "pedidoEntity", cascade = CascadeType.ALL)
    private List<ItemPedidoEntity> itensEntity;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false)
    private EnderecoEntity enderecoEntity;
}
