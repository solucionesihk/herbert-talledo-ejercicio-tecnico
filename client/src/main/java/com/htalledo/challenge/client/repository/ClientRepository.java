package com.htalledo.challenge.client.repository;

import com.htalledo.challenge.client.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
