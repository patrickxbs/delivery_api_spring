package com.patrick.delivery.infrastructure.persistence;

import com.patrick.delivery.infrastructure.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepositoryJpa extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findAllByUsuarioEntityId(Long id);
}
