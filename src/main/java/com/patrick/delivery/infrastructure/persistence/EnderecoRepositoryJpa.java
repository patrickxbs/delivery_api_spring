package com.patrick.delivery.infrastructure.persistence;

import com.patrick.delivery.infrastructure.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepositoryJpa extends JpaRepository<EnderecoEntity, Long> {

    List<EnderecoEntity> findAllByUsuarioEntityId(Long idUsuario);
}
