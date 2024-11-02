package com.htalledo.challenge.movement.service;

import com.htalledo.challenge.movement.dto.MovementDto;

import java.util.Date;
import java.util.List;

public interface MovementService {
    MovementDto registerMovement(MovementDto movementDto) throws Exception;

    MovementDto getMovementById(Long id);
    
    List<MovementDto> getMovementsByAccountId(Long accountId);

    List<MovementDto> getMovementsByAccountIdAndDate(Long accountId, Date startDate, Date endDate);

    void deleteMovement(Long id);

}
