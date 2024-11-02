package com.htalledo.challenge.client.dto;

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
public class PersonDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 19323923L;

    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String phone;
}
