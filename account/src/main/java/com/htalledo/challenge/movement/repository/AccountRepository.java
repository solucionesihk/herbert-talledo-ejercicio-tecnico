package com.htalledo.challenge.movement.repository;

import com.htalledo.challenge.movement.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
    List<AccountEntity> findByClientId(Long clientId);
}
