package com.htalledo.challenge.movement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "movement")
public class MovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(name = "movement_type", nullable = false, length = 50)
    private String movementType;

    private Double value;

    @JoinColumn(name = "account_id", nullable = false)
    @ManyToOne
    private AccountEntity accountEntity;
}
