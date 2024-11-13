package com.htalledo.challenge.account.service;

import com.htalledo.challenge.account.dto.AccountDto;

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
