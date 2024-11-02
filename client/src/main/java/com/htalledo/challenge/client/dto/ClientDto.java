package com.htalledo.challenge.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto extends PersonDto {
    @Serial
    private static final long serialVersionUID = 12913923L;
    private Long id;
    private String password;
    private Boolean status;
}
