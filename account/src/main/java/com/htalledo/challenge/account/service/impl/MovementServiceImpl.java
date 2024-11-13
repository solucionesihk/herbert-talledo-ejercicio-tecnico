package com.htalledo.challenge.account.service.impl;

import com.htalledo.challenge.account.dto.MovementDto;
import com.htalledo.challenge.account.entity.MovementEntity;
import com.htalledo.challenge.account.exception.ResourceNotFoundException;
import com.htalledo.challenge.account.exception.SaldoNoDisponibleException;
import com.htalledo.challenge.account.mapper.MovementMapper;
import com.htalledo.challenge.account.repository.MovementRepository;
import com.htalledo.challenge.account.service.AccountService;
import com.htalledo.challenge.account.service.MovementService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class MovementServiceImpl implements MovementService {
    private final MovementMapper movementMapper;
    private final MovementRepository movementRepository;
    private final AccountService accountService;

    public MovementServiceImpl(MovementMapper movementMapper, MovementRepository movementRepository, AccountService accountService) {
        this.movementMapper = movementMapper;
        this.movementRepository = movementRepository;
        this.accountService = accountService;
    }

    @Override
    public MovementDto registerMovement(MovementDto movementDto) {
        var accountDto = accountService.getAccountById(movementDto.getAccountId());
        double newBalance = accountDto.getAvailableBalance() + movementDto.getValue();
        if (newBalance < 0) {
            throw new SaldoNoDisponibleException("Saldo no disponible");
        }
        log.info("new Balance: {}", newBalance);
        accountDto.setAvailableBalance(newBalance);
        accountService.updateAccount(accountDto.getAccountNumber(), accountDto);

        movementDto.setDate(new Date());
        return movementMapper.entityToDto(movementRepository.save(movementMapper.dtoToEntity(movementDto)));
    }

    @Override
    public MovementDto getMovementById(Long id) {
        return movementMapper.entityToDto(verifyMovementById(id));
    }

    @Override
    public List<MovementDto> getMovementsByAccountId(Long accountId) {
        return movementMapper.entityToDto(movementRepository.findMovementsByAccountId(accountId));
    }

    @Override
    public List<MovementDto> getMovementsByAccountIdAndDate(Long accountId, Date startDate, Date endDate) {
        return movementMapper.entityToDto(movementRepository.findByAccountIdAndDateBetween(accountId, startDate, endDate));
    }

    @Override
    public void deleteMovement(Long id) {
        var movementEntity = verifyMovementById(id);
        movementRepository.delete(movementEntity);
    }

    private MovementEntity verifyMovementById(Long id){
        return movementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movimiento no encontrado"));
    }
}
