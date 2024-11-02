package com.htalledo.challenge.movement.dto;

import com.htalledo.challenge.movement.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 122982982L;

    private Date date;
    private String client;
    private String accountNumber;
    private AccountTypeEnum accountType;
    private Double initialBalance;
    private Boolean status;
    private Double movement;
    private Double availableBalance;

}
