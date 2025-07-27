package com.patrick.delivery.core.domain;

import com.patrick.delivery.enuns.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private Long id;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntregue;
    private StatusPedido statusPedido;
    private String descricao;
    private BigDecimal precoTotal;

    private List<ItemPedido> itens;
    private Usuario usuario;
    private Endereco endereco;

    public Pedido() {
    }

    public Pedido(Long id, LocalDateTime dataPedido, LocalDateTime dataEntregue, StatusPedido statusPedido, String descricao, BigDecimal precoTotal, List<ItemPedido> itens, Usuario usuario, Endereco endereco) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.dataEntregue = dataEntregue;
        this.statusPedido = statusPedido;
        this.descricao = descricao;
        this.precoTotal = precoTotal;
        this.itens = itens;
        this.usuario = usuario;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDateTime getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(LocalDateTime dataEntregue) {
        this.dataEntregue = dataEntregue;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void calcularPrecoTotal() {
        BigDecimal total = itens.stream()
                .map(ItemPedido::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        this.precoTotal = total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dataPedido=" + dataPedido +
                ", dataEntregue=" + dataEntregue +
                ", statusPedido=" + statusPedido +
                ", descricao='" + descricao + '\'' +
                ", precoTotal=" + precoTotal +
                ", itens=" + itens +
                ", usuario=" + usuario +
                '}';
    }
}
