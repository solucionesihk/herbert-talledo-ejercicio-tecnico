package com.htalledo.challenge.account.entity;

import com.htalledo.challenge.account.enums.AccountTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false, length = 20)
    private String accountNumber;

    @Column(name = "account_type", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private AccountTypeEnum accountType;

    @Column(name = "initial_balance", scale = 2)
    private Double initialBalance;

    @Column(name = "available_balance", scale = 2)
    private Double availableBalance;
    private Boolean status;

    @OneToMany(mappedBy = "accountEntity")
    private List<MovementEntity> movements;

    @Column(name = "client_id")
    private Long clientId;
}
