package com.htalledo.challenge.client.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "person")
public abstract class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
    @SequenceGenerator(name = "person_id_seq", sequenceName = "person_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    //@Enumerated(EnumType.STRING)
    @Column(length = 100)
    private String gender;
    private Integer age;

    @Column(length = 255)
    private String address;

    @Column(length = 15)
    private String phone;
}