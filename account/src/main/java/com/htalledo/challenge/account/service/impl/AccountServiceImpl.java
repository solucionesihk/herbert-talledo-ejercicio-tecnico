package com.htalledo.challenge.account.service.impl;

import com.htalledo.challenge.account.dto.AccountDto;
import com.htalledo.challenge.account.entity.AccountEntity;
import com.htalledo.challenge.account.exception.ResourceNotFoundException;
import com.htalledo.challenge.account.mapper.AccountMapper;
import com.htalledo.challenge.account.repository.AccountRepository;
import com.htalledo.challenge.account.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper mapper) {
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) throws Exception {
        var accountEntityOptional = accountRepository.findByAccountNumber(accountDto.getAccountNumber());
        if(accountEntityOptional.isPresent()){
            throw new Exception("Cuenta ya registrada");
        }
        accountDto.setAvailableBalance(accountDto.getInitialBalance());
        return mapper.entityToDto(accountRepository.save(mapper.dtoToEntity(accountDto)));
    }

    @Override
    public AccountDto getAccountByNumber(String accountNumber) {
        AccountEntity accountEntity = verifyAccountByNumber(accountNumber);
        return mapper.entityToDto(accountEntity);
    }

    public AccountDto getAccountById(Long id) {
        AccountEntity accountEntity = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));
        return mapper.entityToDto(accountEntity);
    }

    @Override
    public List<AccountDto> getAccountsByClientId(Long clientId) {
        List<AccountEntity> accountEntity = accountRepository.findByClientId(clientId);
        if (accountEntity == null){
            throw new ResourceNotFoundException("Cuenta no encontrada");
        }
        return mapper.entityToDto(accountEntity);
    }

    @Override
    public AccountDto updateAccount(String accountNumber, AccountDto accountDto) {
        AccountEntity accountEntity = verifyAccountByNumber(accountNumber);
        validateDtoAndSetEntity(accountEntity, accountDto);
        return mapper.entityToDto(accountRepository.save(accountEntity));
    }

    @Override
    public void deleteAccountByNumber(String accountNumber) {
        var accountEntity = verifyAccountByNumber(accountNumber);
        accountRepository.delete(accountEntity);
    }

    @Override
    public void deleteAccountById(Long id) {
        var accountEntity = verifyAccountById(id);
        accountRepository.delete(accountEntity);
    }

    private AccountEntity verifyAccountByNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));
    }

    private AccountEntity verifyAccountById(Long id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada"));
    }

    private void validateDtoAndSetEntity(AccountEntity accountEntity, AccountDto accountDto){
        if(Objects.nonNull(accountDto.getAccountType())){
            accountEntity.setAccountType(accountDto.getAccountType());
        }
        if(Objects.nonNull(accountDto.getInitialBalance())){
            accountEntity.setInitialBalance(accountDto.getInitialBalance());
        }
        if(Objects.nonNull(accountDto.getAvailableBalance())){
            accountEntity.setAvailableBalance(accountDto.getAvailableBalance());
        }
        if(Objects.nonNull(accountDto.getStatus())){
            accountEntity.setStatus(accountDto.getStatus());
        }
        if(Objects.nonNull(accountDto.getClientId())){
            accountEntity.setClientId(accountDto.getClientId());
        }
    }
}
