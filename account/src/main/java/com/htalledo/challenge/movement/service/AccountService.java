package com.htalledo.challenge.movement.service;

import com.htalledo.challenge.movement.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto) throws Exception;

    AccountDto getAccountByNumber(String accountNumber);

    AccountDto getAccountById(Long id);

    List<AccountDto> getAccountsByClientId(Long clientId);

    AccountDto updateAccount(String accountNumber, AccountDto accountDto);

    void deleteAccountByNumber(String accountNumber);

    void deleteAccountById(Long id);
}
