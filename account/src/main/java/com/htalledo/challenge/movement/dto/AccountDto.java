package com.htalledo.challenge.movement.dto;

import com.htalledo.challenge.movement.enums.AccountTypeEnum;
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
public class AccountDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 122982982L;

    private Long id;
    private String accountNumber;
    private AccountTypeEnum accountType;
    private Double initialBalance;
    private Double availableBalance;
    private Boolean status;

    private Long clientId;

}
