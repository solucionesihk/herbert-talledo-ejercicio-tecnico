package com.htalledo.challenge.client.dto;

import lombok.*;

import java.io.Serial;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto extends PersonDto {
    @Serial
    private static final long serialVersionUID = 12913923L;
    private Long id;

    @NonNull
    private String password;
    private Boolean status;
}
