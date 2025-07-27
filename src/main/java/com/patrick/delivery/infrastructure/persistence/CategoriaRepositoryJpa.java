package com.patrick.delivery.infrastructure.persistence;

import com.patrick.delivery.infrastructure.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepositoryJpa extends JpaRepository<CategoriaEntity, Long> {

    Optional<CategoriaEntity> findByNome(String nome);
}
