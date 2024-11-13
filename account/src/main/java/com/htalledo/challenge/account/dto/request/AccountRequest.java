package com.htalledo.challenge.account.dto.request;

import com.htalledo.challenge.account.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 29893893L;

    private AccountDto account;
    private Long clientId;

}
