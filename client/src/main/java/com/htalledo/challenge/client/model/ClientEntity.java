package com.htalledo.challenge.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "client")
public class ClientEntity extends PersonEntity {
    @Column(nullable = false, length = 255)
    private String password;
    
    @Column(nullable = false)
    private Boolean status;
}
