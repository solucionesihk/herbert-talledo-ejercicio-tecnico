package com.htalledo.challenge.movement.repository;

import com.htalledo.challenge.movement.entity.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<MovementEntity, Long> {

    @Query(value = "SELECT m FROM MovementEntity m WHERE m.accountEntity.id = :accountId", nativeQuery = true)
    List<MovementEntity> findMovementsByAccountId(@Param("accountId") Long accountId);

    @Query("SELECT m FROM MovementEntity m WHERE m.accountEntity.id = :accountId AND m.date BETWEEN :startDate AND :endDate")
    List<MovementEntity> findByAccountIdAndDateBetween(@Param("accountId") Long accountId,
                                                         @Param("startDate") Date startDate,
                                                         @Param("endDate") Date endDate);
}
