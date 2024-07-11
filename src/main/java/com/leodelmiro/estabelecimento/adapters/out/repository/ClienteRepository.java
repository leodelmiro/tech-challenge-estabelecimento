package com.leodelmiro.estabelecimento.adapters.out.repository;

import com.leodelmiro.estabelecimento.adapters.out.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
