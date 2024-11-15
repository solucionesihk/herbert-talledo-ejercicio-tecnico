package com.htalledo.challenge.client.dto;

import lombok.*;

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
    @NonNull
    private String name;
    @NonNull
    private String gender;
    @NonNull
    private Integer age;
    private String address;
    private String phone;
}
