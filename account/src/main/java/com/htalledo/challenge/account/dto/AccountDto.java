package com.htalledo.challenge.account.dto;

import com.htalledo.challenge.account.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 122982982L;

    private Long id;
    @NonNull
    private String accountNumber;
    @NonNull
    private AccountTypeEnum accountType;
    private Double initialBalance;
    private Double availableBalance;
    private Boolean status;

    private Long clientId;

}
