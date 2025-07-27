package com.patrick.delivery.infrastructure.persistence;

import com.patrick.delivery.infrastructure.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepositoryJpa extends JpaRepository<ProdutoEntity, Long> {

    Optional<ProdutoEntity> findByNome(String nome);
}
